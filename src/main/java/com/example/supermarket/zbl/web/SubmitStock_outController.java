package com.example.supermarket.zbl.web;


import com.example.supermarket.ljy.domain.Stock_out;
import com.example.supermarket.zbl.service.StockService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/stockout")
public class SubmitStock_outController {
    @Resource
    StockService stockService;

    @RequestMapping(value = "/subStock_out")void  submitStockout(HttpServletResponse response, @RequestBody Stock_out stock_out)throws IOException{
        System.out.println(stock_out.getOutdate());
        Integer content = stockService.insertStockOut(stock_out.getNum(),stock_out.getCnum(),stock_out.getOutdate(),stock_out.getSum(),stock_out.getStu_num());
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(content == 0 ?"0":"1");
    }
}
