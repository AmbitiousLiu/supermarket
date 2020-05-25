package com.example.supermarket.ljy.web

import com.alibaba.fastjson.JSONObject
import com.example.supermarket.ljy.service.StockOutService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession

/**
 * @author jleo
 * @date 2020/4/30
 */
@RestController
@RequestMapping(value = "/stockOut")
class StockOutController {

    @Autowired StockOutService stockOutService

//    def SIZE = 10

    @RequestMapping(value = "/history")
    String moreStockOut(HttpServletRequest request,
                 HttpServletResponse response,
                 @RequestParam(value = "limit", required = true) String size,
                 @RequestParam(value = "page", required = true) String page) {
        def session = request.getSession();
        session.setAttribute("stu_num","202000001");
        session.setAttribute("rnum","01")
        //生成经手人
        String stu_num = (String) session.getAttribute("stu_num");
        //查找经手人角色
        String rnum = session.getAttribute("rnum").toString();
        //定义数据量
        Integer content = 0;

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0 );
        jsonObject.put("msg","");

        response.setContentType("text/json;charset=utf-8")
        if ("01".equals(rnum) || "02".equals(rnum)) {
            content = stockOutService.queryStockoutRows()
            jsonObject.put("count",content);
            jsonObject.put("data",stockOutService.moreStockOut(Integer.parseInt(page),Integer.parseInt(size)))
            return jsonObject.toString()
//            response.getWriter().write(stockOutService.moreStockOut(Integer.parseInt(page), Integer.parseInt(size)))
        } else if ("03".equals(rnum)) {
            content = stockOutService.queryStockoutRowsByStu(stu_num)
            jsonObject.put("count",content);
            jsonObject.put("data",stockOutService.moreStockOutByPerson(stu_num,Integer.parseInt(page),Integer.parseInt(size)))
            return jsonObject.toString()
//            response.getWriter().write(stockOutService.moreStockOutByPerson(session.getAttribute("stu_num").toString(), Integer.parseInt(page), Integer.parseInt(size)))
        }
    }

    @RequestMapping(value = "/detail")
    checkStockOut(@RequestParam(value = "num", required = true) String num,
                  HttpServletResponse response,
                  HttpSession session) {
        response.setContentType("text/json;charset=utf-8")
        response.getWriter().write(stockOutService.stockOutDetail(num, session) ?: "")
    }

}
