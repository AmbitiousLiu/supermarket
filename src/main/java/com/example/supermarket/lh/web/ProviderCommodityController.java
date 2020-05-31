package com.example.supermarket.lh.web;


import com.example.supermarket.lh.service.ProviderCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@RestController
@RequestMapping(value = "/providerCom")
public class ProviderCommodityController {
    @Autowired
    public ProviderCommodityService providerCommodityService;

    @GetMapping(value = "getCommodities")
    //通过商家号查询商家商品
    public void getCommodities(HttpServletResponse response, HttpSession session, @RequestParam(value = "pnum")String pnum)
                                    throws IOException {

        //生成日期
        long time = System.currentTimeMillis();
        Date qdate = new Date(time);
        providerCommodityService.insertData(session.getAttribute("stu_num").toString(),"购入商品",qdate);

        String content = providerCommodityService.getProviderCommodityByPnum(pnum);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(content == null ? "" : content);
    }
    @GetMapping(value = "getComInfo")
    public  void getComInfo(HttpServletResponse response,HttpSession session, @RequestParam(value = "cnum")String cnum)
            throws IOException{

        //生成日期
        long time = System.currentTimeMillis();
        Date qdate = new Date(time);
        providerCommodityService.insertData(session.getAttribute("stu_num").toString(),"购入商品",qdate);

        String content = providerCommodityService.getComInfo(cnum);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(content == null ? "" : content);

    }
}
