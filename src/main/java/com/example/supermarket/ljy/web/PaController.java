package com.example.supermarket.ljy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ljy")
public class PaController {
    @RequestMapping("about")
    public String about()
    {
        return "../static/ljy/about";
    }
    @RequestMapping("commodity")
    public String commodity()
    {
        return "../static/ljy/commodity";
    }
    @RequestMapping("echarts")
    public String echarts()
    {
        return "../static/ljy/echarts";
    }
    @RequestMapping("historyStockIn")
    public String historyStockIn()
    {
        return "../static/ljy/historyStockIn";
    }
    @RequestMapping("historyStockOut")
    public String historyStockOut()
    {
        return "../static/ljy/historyStockOut";
    }
    @RequestMapping("manage")
    public String manage()
    {
        return "../static/ljy/manage";
    }
    @RequestMapping("manage_role")
    public String manage_lore()
    {
        return "../static/ljy/manage_role";
    }
    @RequestMapping("manage_stuff")
    public String manage_stuff()
    {
        return "../static/ljy/manage_stuff";
    }
    @RequestMapping("provider")
    public String provider()
    {
        return "../static/ljy/provider";
    }
    @RequestMapping("provider_commodity")
    public String provider_commodity()
    {
        return "../static/ljy/provider_commodity";
    }
    @RequestMapping("stock")
    public String stock()
    {
        return "../static/ljy/stock";
    }
    @RequestMapping("stock_in")
    public String stock_in()
    {
        return "../static/ljy/stock_in";
    }
    @RequestMapping("stock_out")
    public String stock_out()
    {
        return "../static/ljy/stock_out";
    }

}
