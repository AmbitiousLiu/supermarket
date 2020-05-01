package com.example.supermarket.ljy.web

import com.example.supermarket.ljy.service.StockOutService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author jleo
 * @date 2020/4/30
 */
@RestController
@RequestMapping(value = "/stockOut")
class StockOutController {

    @Autowired StockOutService stockOutService

    def SIZE = 10

    @RequestMapping(value = "history")
    moreStockOut(HttpServletRequest request,
                 HttpServletResponse response,
                 @RequestParam(value = "page", required = true) String page) {
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
            response.getWriter().write(stockOutService.moreStockOut(Integer.parseInt(page), SIZE))
        } else if (position.equals("manager")) {
            response.getWriter().write(stockOutService.moreStockOutByPerson(session.getAttribute("stu_num").toString(), Integer.parseInt(page), SIZE))
        }
    }

    @RequestMapping(value = "detail")
    checkStockOut(@RequestParam(value = "num", required = true) String num,
                  HttpServletResponse response) {
        response.setContentType("text/json;charset=utf-8")
        response.getWriter().write(stockOutService.stockOutDetail(num))
    }

}
