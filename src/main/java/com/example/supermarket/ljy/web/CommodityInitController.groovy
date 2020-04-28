package com.example.supermarket.ljy.web

import com.example.supermarket.ljy.service.CommodityInitService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpServletResponse

/**
 * @author jleo
 * @date 2020/4/27
 */
@RestController
@RequestMapping(value = "/commodity")
class CommodityInitController {

    @Autowired CommodityInitService commodityInitService

    /**
     * url:/commodity/commodity ('content ?: ""' means return "" if content is null)
     * @param response: json string of commodities's data
     * @return
     */
    @GetMapping(value = "/commodity") initCommodity(HttpServletResponse response) {
        def content = commodityInitService.getAllCommodities()
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(content ?: "");
    }

}
