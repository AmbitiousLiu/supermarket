package com.example.supermarket.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {//页面访问
    @RequestMapping("/person.html")
    public String login(){
        return "person";
    }
    @RequestMapping("/person")
    public String login1(){
        return "person";
    }
    @RequestMapping("/index.html")
    public String index(){
        return "index";
    }
}
