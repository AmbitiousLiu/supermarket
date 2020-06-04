package com.example.supermarket.ljy.web

import com.example.supermarket.ljy.hadoop.Hdfs
import com.example.supermarket.ljy.service.CommodityInitService
import com.example.supermarket.ljy.service.StockOutService
import com.example.supermarket.zbl.web.GetcnumController
import org.apache.log4j.Logger
import org.apache.log4j.spi.LoggingEvent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession
import java.sql.Date

/**
 * @author jleo
 * @date 2020/4/27
 */
@RestController
@RequestMapping(value = "/commodity")
class CommodityInitController {

    @Autowired CommodityInitService commodityInitService
    @Autowired StockOutService stockOutService
    private static Logger logger = Logger.getLogger(GetcnumController.class);
    LoggingEvent loggingEvent;
    /**
     * GET:/commodity/commodity ('content ?: ""' means return "" if content is null)
     * @param response: json string of commodities's data
     * @return
     */
    @GetMapping(value = "/commodity") initCommodity(HttpSession session, HttpServletResponse response) {
        def content
        long time = System.currentTimeMillis();
        Date qdate = new Date(time)
        commodityInitService.insertData(session.getAttribute("stu_num").toString(),"商品管理",qdate);
        logger.info("name:" + session.getAttribute("name".toString()));
        content = commodityInitService.getAllCommodities()
        response.setContentType("text/json;charset=utf-8")
        response.getWriter().write(content ?: "")
    }

    @GetMapping(value = "/initStockOut")
    initStockOut(HttpServletRequest request, HttpServletResponse response) {
        def session = request.getSession();
        if (session == null) {
            return
        }
        session.setAttribute("rnum","01");
        //拿到角色
        String rnum = (String) session.getAttribute("rnum");
        String stu_num = (String) session.getAttribute("rnum");
//        String position = session.getAttribute("position")
        if (rnum == null) {
            return
        }
        response.setContentType("text/json;charset=utf-8")
        logger.info("name:" + session.getAttribute("name".toString()));
        if ( "01".equals(rnum)|| "02".equals(rnum)) {
            logger.info("name:" + session.getAttribute("name".toString()) + " is a Manager so get all datas");
            response.getWriter().write(stockOutService.initStockOut())
        } else  {
            logger.info("name:" + session.getAttribute("name".toString()) + " is a store Manager so get datas that deal by he")
            response.getWriter().write(stockOutService.initStockOutByPerson(stu_num));
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
