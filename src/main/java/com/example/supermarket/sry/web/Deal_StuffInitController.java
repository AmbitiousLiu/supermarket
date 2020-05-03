package com.example.supermarket.sry.web;
import com.example.supermarket.sry.service.Deal_CommodityInitService;
import com.example.supermarket.sry.service.Deal_StuffInitService;
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
class Deal_StuffInitController {

    @Autowired
    public Deal_StuffInitService dealStuffInitService;

    /**
     * GET:/deal/stuff ('content ?: ""' means return "" if content is null)
     * @param response: json string of commodities's data
     * @return
     */
    @GetMapping(value = "/stuff")
    public void initCommodity(HttpServletResponse response) throws IOException {
        String content = dealStuffInitService.getAllStufves();
        response.setContentType("text/json;charset=utf-8");
        if (content == null) {
            response.getWriter().write("");
        } else {
            response.getWriter().write(content);
        }

    }

    /**
     * POST:/commodity/deal
     * @param stu_num: it's not required
     * @param response: json string if commodities's data
     * @return
     */
    @PostMapping(value = "/stuff")
    public void initCommodityByParam(@RequestParam(value = "stu_num", required = false) String stu_num,
                                     HttpServletResponse response)  throws IOException  {
        String content;
        if (stu_num != null) {
            content = dealStuffInitService.getStufvesByStu_num(stu_num);
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