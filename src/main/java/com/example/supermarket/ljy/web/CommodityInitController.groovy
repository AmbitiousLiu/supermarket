package com.example.supermarket.ljy.web

import com.example.supermarket.ljy.service.CommodityInitService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
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
     * GET:/commodity/commodity ('content ?: ""' means return "" if content is null)
     * @param response: json string of commodities's data
     * @return
     */
    @GetMapping(value = "/commodity") initCommodity(HttpServletResponse response) {
        def content = commodityInitService.getAllCommodities()
        response.setContentType("text/json;charset=utf-8")
        response.getWriter().write(content ?: "")
    }

    /**
     * POST:/commodity/commodity
     * @param cnum: it's not required
     * @param sort: it's not required
     * @param response: json string if commodities's data
     * @return
     */
    @PostMapping(value = "/commodity") initCommodityByParam(@RequestParam(value = "cnum", required = false) String cnum,
                                                            @RequestParam(value = "sort", required = false) String sort,
                                                            HttpServletResponse response) {
        def content
        if (cnum != null) {
            content = commodityInitService.getCommodityByCnum(cnum)
        } else {
            if (sort != null) {
                content = commodityInitService.getCommoditiesBySort(sort)
            } else {
                content = ""
            }
        }
        response.setContentType("text/json;charset=utf-8")
        response.getWriter().write(content ?: "")
    }

}
