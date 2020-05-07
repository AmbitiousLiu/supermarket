package com.example.supermarket.sry.web;

import com.example.supermarket.sry.Redis.Redis;
import com.example.supermarket.sry.service.Deal_StockOutInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/deal")
public class Deal_StockOutInitController {
    Redis redis = new Redis();
    @Autowired
    Deal_StockOutInitService deal_StockOutInitService;

    /**
     * GET:/deal/stock_out_detail
     * @param num: it's not required
     * @param response: json string if commodities's data
     * @return
     */
    @GetMapping(value = "stock_out_detail")
    public void initCommodityByParam(@RequestParam(value = "num", required = false) String num,
                                     HttpServletResponse response)  throws IOException{
        String content;

        if (num != null) {

            if(redis.exists("num_"+num)){
                content = redis.get("num_"+num);
            }else{
                content = deal_StockOutInitService.getStockOutByNum(num);
                redis.set("cnum_"+num,content);
                redis.expire("cnum_"+num, 3600);
            }
        } else {
            content = "";
        }
        response.setContentType("text/json;charset=utf-8");
        if (content == null) {
            response.getWriter().write("");
        } else {
            response.getWriter().write(content);
        }
    }
}
