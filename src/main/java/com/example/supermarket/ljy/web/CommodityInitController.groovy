package com.example.supermarket.ljy.web

import com.example.supermarket.ljy.service.CommodityInitService
import com.example.supermarket.ljy.service.StockOutService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author jleo
 * @date 2020/4/27
 */
@RestController
@RequestMapping(value = "/commodity")
class CommodityInitController {

    @Autowired CommodityInitService commodityInitService
    @Autowired StockOutService stockOutService

    /**
     * GET:/commodity/commodity ('content ?: ""' means return "" if content is null)
     * @param response: json string of commodities's data
     * @return
     */
    @GetMapping(value = "/commodity") initCommodity(HttpServletRequest request, HttpServletResponse response) {
//        def session = request.getSession()
//        String position = session.getAttribute("position")
//        def content
//        if (position == "president") {
//            content = commodityInitService.getAllCommodities()
//        } else if (position == "manager") {
//            content = commodityInitService.getCommoditiesBySort(session.getAttribute("region")?.toString())
//        } else {
//            return
//        }
//        response.setContentType("text/json;charset=utf-8")
//        response.getWriter().write(content ?: "")
        def content = commodityInitService.getAllCommodities()
        response.setContentType("text/json;charset=utf-8")
        response.getWriter().write(content)
    }

    @GetMapping(value = "/initStockOut")
    initStockOut(HttpServletRequest request, HttpServletResponse response) {
        def session = request.getSession();
        if (session == null) {
            return
        }
        String position = session.getAttribute("position")
        if (position == null) {
            return
        }
        response.setContentType("text/json;charset=utf-8")
        if (position.equals("president")) {
            response.getWriter().write(stockOutService.initStockOut())
        } else if (position.equals("manager")) {
            response.getWriter().write(stockOutService.initStockOutByPerson(session.getAttribute("stu_num").toString()))
        }
    }

    @GetMapping(value = "/region")
    initRegion(HttpServletRequest request) {
        def session = request.getSession()
        String region = session.getAttribute("region")
        return region ?: ""
    }

    @GetMapping(value = "/userName")
    initUserName(HttpServletRequest request) {
        def session = request.getSession()
        String name = session.getAttribute("name")
        return name ?: ""
    }

    @GetMapping(value = "/userPosition")
    initUserPosition(HttpServletRequest request) {
        def session = request.getSession()
        String position = session.getAttribute("position")
        return position ?: ""
    }

}
