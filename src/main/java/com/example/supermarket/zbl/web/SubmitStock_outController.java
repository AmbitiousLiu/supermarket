package com.example.supermarket.zbl.web;


import com.example.supermarket.ljy.domain.Stock_out;
import com.example.supermarket.zbl.service.StockService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/stockout")
public class SubmitStock_outController {
    @Resource
    StockService stockService;
    private static Logger logger = Logger.getLogger(SubmitStock_outController.class);
    @RequestMapping(value = "/subStock_out")void  submitStockout(HttpServletResponse response, @RequestBody Stock_out stock_out, HttpSession session)throws IOException {
       String stu_num = session.getAttribute("stu_num").toString();

        response.setContentType("text/json;charset=utf-8");
        Integer sum = stockService.querySum(stock_out.getCnum());
        String num = stockService.queryNum(stock_out.getNum());
        List<String> cnums = stockService.queryCnums();
        Boolean flag = false;

        for (String cnum:cnums){
            if (cnum.equals(stock_out.getCnum())){
                flag = true;
            }
        }


        //判断出库单号是否重复
        if ( num == null) {
            //判断出库单中的商品号是否存在
            if (flag){
                //当出库数量小于入库数量时，出库成功
                if (stock_out.getSum() <= sum) {
                    Integer content = stockService.insertStockOut(stock_out.getNum(), stock_out.getCnum(), stock_out.getOutdate(), stock_out.getSum(), stu_num);

                    if (content == 0) {
                        response.getWriter().write("-1");
                    } else {
                        stockService.updateSum(stock_out.getCnum(), sum - stock_out.getSum());
                        stockService.updateCom(stock_out.getSum(),stock_out.getCnum());
                        response.getWriter().write("-2");
                    }

                }//否则失败
                else {
                    response.getWriter().write(sum.toString());
                }
            }else {
                response.getWriter().write("-4");
            }


        }else {
            response.getWriter().write("-3");
        }
    }
    //拿到商品号
    @RequestMapping(value = "/getCnum")
    void  getCnum(HttpServletResponse response)throws IOException{
        String content = stockService.queryCnum();
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(content == null ?"0":content);
    }

}
