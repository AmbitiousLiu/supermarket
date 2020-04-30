//package com.example.supermarket.lh.web;
//
//import com.example.supermarket.lh.domain.StockOut;
//import com.example.supermarket.lh.service.StockOutInitService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.*;
//
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@RestController
//@RequestMapping(value = "/Info")
//public class StockOutInitController {
//    @Autowired StockOutInitService stockOutInitService;
//
//    @PostMapping(value = "/getInfo") void initStockOut(HttpServletResponse response, @SessionAttribute(value = "num" ,required = true)String num)throws IOException {
//        String content = stockOutInitService.getAllInfo(num);
//        response.setContentType("text/json;charset=utf-8");
//        response.getWriter().write(content==null ?"":content);
//
//    }
//
//}
