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
    public void addStock(@RequestBody Stock_in stock_in,
                         HttpServletResponse response,
                         HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        String stu_num = (String) session.getAttribute("stu_num");
        String content = null;
        stockInService.addStock(stock_in.getNum(),stock_in.getPname(),stock_in.getCnum(),stock_in.getIndate(),stock_in.getSum(),stu_num);
        response.setContentType("text/json;charset=utf-8");
        if (content.equals("null")) {
            response.getWriter().write("");
        } else {
            response.getWriter().write(content);
        }
    }
}
