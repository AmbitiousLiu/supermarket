package com.example.supermarket.lh.web;

import com.example.supermarket.lh.service.StockOutInitService;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/stockOutAD")
public class StockOutInitController {
    @Autowired StockOutInitService stockOutInitService;

    @RequestMapping(value = "/getStockOutAD") void initStockOutAD(HttpServletResponse response)throws IOException {
        String content = stockOutInitService.getAllStockout();
        response.setContentType("text/json;charset=utf-8");
        if (content == null) {
            response.getWriter().write("");
        } else {
            response.getWriter().write(content);
        }

    }
    @RequestMapping (value = "/insertStockOutAD") void insertStockOutAD(HttpServletResponse response,@RequestParam(value = "num" ,required = true) Person person)throws IOException{

    }
    @RequestMapping (value = "/deleteStockOutAD") void deleteStockOutADByParam(HttpServletResponse response, @RequestParam(value = "num" ,required = true) String num)throws IOException{
        String content;
        if(num != null){
            content = stockOutInitService.deleteStockOutADByParam(num);
        } else{
            content = "not num";
        }
        response.setContentType("text/json;charset=utf-8");
        if(content.length() <= 1){
            response.getWriter().write("Delete success");
        } else{
            response.getWriter().write(content);
        }
    }

}