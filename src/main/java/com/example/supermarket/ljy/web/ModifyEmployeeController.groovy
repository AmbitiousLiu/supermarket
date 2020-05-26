package com.example.supermarket.ljy.web

import com.alibaba.fastjson.JSONObject
import com.example.supermarket.ljy.service.ModifyEmployeeService
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

    @RequestMapping("/delete")
    def delete(@RequestParam("tiaojian") String tiaojian, @RequestParam("tiaojianzhi") String tiaojianzhi, HttpServletResponse response) {
        def i = modifyEmployeeService.delete(tiaojian, tiaojianzhi)
        def json = new JSONObject()
        response.setContentType("text/json;charset=utf-8")
        if (i > 0) {
            json.put("code", 0)
            response.getWriter().write(json.toString())
        } else {
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
        def i = modifyEmployeeService.update(tiaojian, tiaojianzhi, gaixinxi, xiugaizhi)
        def json = new JSONObject()
        response.setContentType("text/json;charset=utf-8")
        if (i > 0) {
            json.put("code", 0)
            response.getWriter().write(json.toString())
        } else {
            json.put("code", 1)
            response.getWriter().write(json.toString())
        }
    }

}
