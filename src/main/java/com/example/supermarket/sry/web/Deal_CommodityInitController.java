package com.example.supermarket.sry.web;
import com.example.supermarket.sry.service.Deal_CommodityInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/deal")
class Deal_CommodityInitController {

    @Autowired
    public Deal_CommodityInitService dealCommodityInitService;

    /**
     * GET:/commodity/deal ('content ?: ""' means return "" if content is null)
     * @param response: json string of commodities's data
     * @return
     */
    @GetMapping(value = "/commodity")
    public void initCommodity(HttpServletResponse response) throws IOException {
        String content = dealCommodityInitService.getAllCommodities();
        response.setContentType("text/json;charset=utf-8");
        if (content == null) {
            response.getWriter().write("");
        } else {
            response.getWriter().write(content);
        }
        
    }

    /**
     * POST:/commodity/deal
     * @param cnum: it's not required
     * @param sort: it's not required
     * @param response: json string if commodities's data
     * @return
     */
    @PostMapping(value = "/commodity")
    public void initCommodityByParam(@RequestParam(value = "cnum", required = false) String cnum,
                                                            @RequestParam(value = "sort", required = false) String sort,
                                                            HttpServletResponse response)  throws IOException  {
        String content;
        if (cnum != null) {
            content = dealCommodityInitService.getCommodityByCnum(cnum);
        } else {
            if (sort != null) {
                content = dealCommodityInitService.getCommoditiesBySort(sort);
            } else {
                content = "";
            }
        }
        response.setContentType("text/json;charset=utf-8");
        if (content == null) {
            response.getWriter().write("");
        } else {
            response.getWriter().write(content);
        } 
    }

}
