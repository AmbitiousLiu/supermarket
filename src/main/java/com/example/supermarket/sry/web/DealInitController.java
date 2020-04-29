package com.example.supermarket.sry.web;
import com.example.supermarket.sry.service.DealInitService;
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
class DealInitController {

    @Autowired
    public DealInitService dealInitService;

    /**
     * GET:/commodity/deal ('content ?: ""' means return "" if content is null)
     * @param response: json string of commodities's data
     * @return
     */
    @GetMapping(value = "/deal")
    public void initCommodity(HttpServletResponse response) throws IOException {
        String content = dealInitService.getAllCommodities();
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
    @PostMapping(value = "/deal")
    public void initCommodityByParam(@RequestParam(value = "cnum", required = false) String cnum,
                                                            @RequestParam(value = "sort", required = false) String sort,
                                                            HttpServletResponse response)  throws IOException  {
        String content;
        if (cnum != null) {
            content = dealInitService.getCommodityByCnum(cnum);
        } else {
            if (sort != null) {
                content = dealInitService.getCommoditiesBySort(sort);
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
