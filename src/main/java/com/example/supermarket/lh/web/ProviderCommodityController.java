package com.example.supermarket.lh.web;


import com.example.supermarket.lh.service.ProviderCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/providerCom")
public class ProviderCommodityController {
    @Autowired
    public ProviderCommodityService providerCommodityService;

    @GetMapping(value = "getCommodities")
    //通过商家号查询商家商品
    public void getCommodities(HttpServletResponse response, @RequestParam(value = "pnum")String pnum)
                                    throws IOException {

        String content = providerCommodityService.getProviderCommodityByPnum(pnum);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(content == null ? "" : content);
    }
    @GetMapping(value = "getComInfo")
    public  void getComInfo(HttpServletResponse response, @RequestParam(value = "cnum")String cnum)
            throws IOException{
        String content = providerCommodityService.getComInfo(cnum);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(content == null ? "" : content);

    }
}
