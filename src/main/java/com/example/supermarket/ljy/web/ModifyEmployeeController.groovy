package com.example.supermarket.ljy.web

import com.alibaba.fastjson.JSONObject
import com.example.supermarket.ljy.service.ModifyEmployeeService
import com.example.supermarket.zbl.web.GetcnumController
import org.apache.log4j.Logger
import org.apache.log4j.spi.LoggingEvent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpServletResponse

/**
 * @author jleo
 * @date 2020/5/26
 */
@RestController
@RequestMapping("/modify")
class ModifyEmployeeController {

    @Autowired
    ModifyEmployeeService modifyEmployeeService
    private static Logger logger = Logger.getLogger(GetcnumController.class);
    LoggingEvent loggingEvent;
    @RequestMapping("/delete")
    def delete(@RequestParam("tiaojian") String tiaojian, @RequestParam("tiaojianzhi") String tiaojianzhi, HttpServletResponse response) {
        logger.info("name:" + session.getAttribute("name".toString()));
        def i = modifyEmployeeService.delete(tiaojian, tiaojianzhi)
        def json = new JSONObject()
        response.setContentType("text/json;charset=utf-8")
        if (i > 0) {
            logger.error("Delete false!");
            json.put("code", 0)
            response.getWriter().write(json.toString())
        } else {
            logger.info("Delete Success!")
            json.put("code", 1)
            response.getWriter().write(json.toString())
        }
    }

    @RequestMapping("/update")
    def update(@RequestParam("tiaojian") String tiaojian,
               @RequestParam("tiaojianzhi") String tiaojianzhi,
               @RequestParam("gaixinxi") String gaixinxi,
               @RequestParam("xiugaizhi") String xiugaizhi,
               HttpServletResponse response) {

        logger.info("name:" + session.getAttribute("name".toString()));
        def i = modifyEmployeeService.update(tiaojian, tiaojianzhi, gaixinxi, xiugaizhi)
        def json = new JSONObject()
        response.setContentType("text/json;charset=utf-8")
        if (i > 0) {
            logger.error("Update Error!");
            json.put("code", 0)
            response.getWriter().write(json.toString())
        } else {
            logger.info("Update Success");
            json.put("code", 1)
            response.getWriter().write(json.toString())
        }
    }

}
