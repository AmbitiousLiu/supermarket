package com.example.supermarket.lh.web;

import com.example.supermarket.lh.service.StockInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.sql.Date;


@RestController
@RequestMapping(value = "/stockIn")
public class StockInController {

    @Autowired
    StockInService stockInService;

    /**
     * POST:/commodity/deal
     * @param num: it's not required
     * @param pname: it's not required
     * @param cnum: it's not required
     * @param indate: it's not required
     * @param sum: it's not required
     * @param response: json string if commodities's data
     * @return
     */
    @PostMapping(value = "/add")
    public void addStock(@RequestParam(value = "num", required = false) String num,
                         @RequestParam(value = "pname", required = false) String pname,
                         @RequestParam(value = "cnum", required = false) String cnum,
                         @RequestParam(value = "indate", required = false) Date indate,
                         @RequestParam(value = "sum", required = false) Integer sum,
                         @RequestParam(value = "stu_num", required = false) String stu_num,
                         HttpServletResponse response) {
        stockInService.addStock(num, pname,cnum, indate, sum, stu_num);
    }

}
