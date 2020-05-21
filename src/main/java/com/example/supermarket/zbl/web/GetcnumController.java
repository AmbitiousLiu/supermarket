package com.example.supermarket.zbl.web;


import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class GetcnumController {

    //获得用户名
    @GetMapping (value = "/userName")
    void initUsername(HttpServletRequest request ,HttpServletResponse response )throws IOException {
        String name = request.getSession().getAttribute("name").toString();
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(name==null ?"":name);


    }
}
