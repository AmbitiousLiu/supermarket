package com.example.supermarket.lh.web;

import com.alibaba.fastjson.JSONObject;
import com.example.supermarket.lh.domain.Stock_in;
import com.example.supermarket.lh.service.StockInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;


@RestController
@RequestMapping(value = "/stockIn")
public class StockInController {

    @Autowired
    StockInService stockInService;

    /**
     * POST:/commodity/deal
     * @return
     */
    @RequestMapping(value = "/add")
    public void addStock(@RequestParam(value = "pnum")String pnum,@RequestParam(value = "sum")String sum,
                         @RequestParam(value = "cnum")String cnum,@RequestParam(value = "num")String stockin_id,
                         HttpServletResponse response,
                         HttpServletRequest request) throws IOException {
        response.setContentType("text/json;charset=utf-8");
        HttpSession session = request.getSession();
//        session.setAttribute("stu_num","202000001");


        //生成经手人
        String stu_num = (String) session.getAttribute("stu_num");

        //生成入库日期
        long time = System.currentTimeMillis();
        Date indate = new Date(time);

        //查询生产日期
        Date p_date= stockInService.queryPdate(pnum, cnum);
        //查询保质期
        String safe_date= stockInService.querySafedate(pnum, cnum);
        //查询商品名称
        String pname = stockInService.queryPname(pnum, cnum);
        //查询商品所属区域
        String region = stockInService.queryRegion(pnum, cnum);
        //查询商品进价
        Integer price = stockInService.queryPrice(pnum, cnum);
        //生成出库单
        Stock_in stock_in = new Stock_in(stockin_id,pnum,cnum,indate,p_date,safe_date,Integer.parseInt(sum),stu_num,region,price);

        //插入足迹
        stockInService.insertData(session.getAttribute("stu_num").toString(),"购入商品",indate);

        //插入入库表
        Integer content = stockInService.addStock(stock_in.getNum(),stock_in.getPnum(),
                stock_in.getCnum(),stock_in.getIndate(),stock_in.getSum(),stu_num,
                stock_in.getRegion(),stock_in.getP_date(),stock_in.getSafe_date(),stock_in.getPrice());
        if (content != 0 ){
            //判断数据库内是否有该商品，没有则添加该商品，有则更新商品数量
            if (stockInService.queryCnum(stock_in.getCnum()).isEmpty()){
                //添加库存
                stockInService.addStore(stock_in.getCnum(),pname,stock_in.getRegion(),stock_in.getSum(),
                        stock_in.getP_date(),stock_in.getSafe_date(),stock_in.getPrice());
            }else {
                //更新库存
                stockInService.updateStore(stock_in.getSum(),stock_in.getCnum());
            }
            //插入出库单成功
            response.getWriter().write("1");
        }else{
            //插入出库单失败
            response.getWriter().write("0");
        }
    }

    @RequestMapping(value = "/history")
    public  String  queryHistory( HttpServletResponse response, HttpServletRequest request ,
                                @RequestParam(value = "limit", required = true) String size,
                                @RequestParam(value = "page", required = true) String page) throws IOException{
        HttpSession session = request.getSession();
        response.setContentType("text/json;charset=utf-8");
        //生成经手人
        String stu_num = (String) session.getAttribute("stu_num");
        //查找经手人角色
        String position = stockInService.queryRnum(stu_num).toString();
        //定义数据量
        Integer content = 0;

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0 );
        jsonObject.put("msg","");
        //如果经手人是总经理或者副总经理
        if ("1".equals(position) || "2".equals(position)){
//            System.out.println(stockInService.moreStockIn(Integer.parseInt(page),Integer.parseInt(size)));
            content = stockInService.queryStockInRows();
            jsonObject.put("count",content);
            jsonObject.put("data",stockInService.moreStockIn(Integer.parseInt(page),Integer.parseInt(size)));
            return  jsonObject.toString();
        }else if ("3".equals(position) ){
            //如果经手人是仓库管理员
            content = stockInService.queryStockInRowsByStu(stu_num);
            jsonObject.put("count",content);
            jsonObject.put("data",stockInService.moreStockInByPerson(stu_num,Integer.parseInt(page),Integer.parseInt(size)));
            return  jsonObject.toString();

        }
        return null;
    }

//    @RequestMapping(value = "/getRows")
//    public void getRows(HttpServletResponse response, HttpSession session)throws IOException{
//        response.setContentType("text/json;charset=utf-8");
//        session.setAttribute("stu_num","202000001");
//        //生成经手人
//        String stu_num = (String) session.getAttribute("stu_num");
//        //获得角色号
//        String rnum = stockInService.queryRnum(stu_num);
//        //定义数据量
//        Integer content = 0;
//        //如果是总经理或副总经理,则拿到所有数据
//        if ("01".equals(rnum)||"02".equals(rnum)){
//            content = stockInService.queryStockInRows();
//            //如果是仓库管理员，则拿到自己经手的出库单数据
//        }else {
//            content = stockInService.queryStockInRowsByStu(stu_num);
//        }
//        response.setContentType("text/json;charset=utf-8");
//        response.getWriter().write(content == 0 ? 0 :content);
//    }
}
