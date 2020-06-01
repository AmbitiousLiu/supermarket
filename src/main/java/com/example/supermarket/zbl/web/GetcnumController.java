package com.example.supermarket.zbl.web;


import com.example.supermarket.ws.service.StuffServicelmpl;
import org.apache.catalina.Session;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class GetcnumController {
    @Resource
    StuffServicelmpl stuffServicelmpl;
    //获得用户名
    @GetMapping (value = "/userName")
    void initUsername(HttpServletRequest request ,HttpServletResponse response ) throws Exception {
        String name = request.getSession().getAttribute("name").toString();
        HttpSession session=request.getSession();
        String username=session.getAttribute("stu_num").toString();
        String password=session.getAttribute("password").toString();
        stuffServicelmpl.checkLogin(username,password);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(name==null ?"":name);


    }
}
