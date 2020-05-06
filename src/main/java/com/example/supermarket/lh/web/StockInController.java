package com.example.supermarket.lh.web;

import com.example.supermarket.lh.service.StockInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;


@RestController
@RequestMapping(value = "/stockIn")
public class StockInController {

    @Autowired
    StockInService stockInService;

    @RequestMapping(value = "/add")
    public void addStock(HttpServletRequest request) {
        String num = request.getParameter("num");
        String pname = request.getParameter("pname");
        String cnum = request.getParameter("cnum");
        Date indate = Date.valueOf(request.getParameter("indate"));
        Integer sum = Integer.parseInt(request.getParameter("sum"));
        String stu_num = request.getSession().getAttribute("stu_num").toString();
        stockInService.addStock(num, pname,cnum, indate, sum, stu_num);
    }

}
