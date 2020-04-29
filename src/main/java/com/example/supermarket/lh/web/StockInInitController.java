package com.example.supermarket.lh.web;

import com.example.supermarket.lh.domain.StockIn;
import com.example.supermarket.lh.service.StockInInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/Info")
public class StockInInitController {
    @Autowired StockInInitService stockInInitService;

    @PostMapping(value = "/getInfo") void initStockIn(HttpServletResponse response, @SessionAttribute(value = "num" ,required = true)String num)throws IOException {
        String content = stockInInitService.getAllInfo(num);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(content==null ?"":content);

    }

}
