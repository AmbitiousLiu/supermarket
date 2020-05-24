package com.example.supermarket.lh.web;

import com.example.supermarket.lh.domain.Stock_in;
import com.example.supermarket.lh.service.StockInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.Date;
import java.util.UUID;


@RestController
@RequestMapping(value = "/stockIn")
public class StockInController {

    @Autowired
    StockInService stockInService;

    /**
     * POST:/commodity/deal
     * @return
     */
    @PostMapping(value = "/add")
    public void addStock(@RequestParam(value = "pnum")String pnum,@RequestParam(value = "sum")String sum,
                         @RequestParam(value = "cnum")String cnum,@RequestParam(value = "num")String stockin_id,
                         HttpServletResponse response,
                         HttpServletRequest request) throws IOException {
        response.setContentType("text/json;charset=utf-8");
        HttpSession session = request.getSession();
        session.setAttribute("stu_num","202000001");

        //生成经手人
        String stu_num = (String) session.getAttribute("stu_num");

        //生成入库单号
//        String s = UUID.randomUUID().toString();
//        String stockin_id = s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);

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

        //插入入库表
        Integer content = stockInService.addStock(stock_in.getNum(),stock_in.getPnum(),
                stock_in.getCnum(),stock_in.getIndate(),stock_in.getSum(),stu_num,
                stock_in.getRegion(),stock_in.getP_date(),stock_in.getSafe_date(),stock_in.getPrice());
        if (content != 0 ){
            //判断数据库内是否有该商品，没有则添加该商品，有则更新商品数量
//            System.out.println(stockInService.queryCnum(stock_in.getCnum()));
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
}
