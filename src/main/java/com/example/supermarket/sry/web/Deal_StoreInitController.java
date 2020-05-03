package com.example.supermarket.sry.web;

import com.example.supermarket.sry.service.Deal_StoreInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/deal")
public class Deal_StoreInitController {
    @Autowired
    public Deal_StoreInitService dealStoreInitService;

    /**
     * GET:/deal/Commodity
     * @param cnum: it's not required
     * @param response: json string if commodities's data
     * @return
     */
    @GetMapping(value = "/store")
    public void initCommodityByParam(@RequestParam(value = "cnum", required = false) String cnum,
                                     HttpServletResponse response)  throws IOException {
        String content;
        if (cnum != null) {
            content = dealStoreInitService.getStoreByCnum(cnum);
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
