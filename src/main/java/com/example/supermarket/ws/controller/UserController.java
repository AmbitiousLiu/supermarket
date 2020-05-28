package com.example.supermarket.ws.controller;

import com.example.supermarket.ws.service.StuffServicelmpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    private StuffServicelmpl stuffServicelmpl;

    @RequestMapping("login")
    public String login(String username,String password)  {
        System.out.println("我在这");
        try {
            stuffServicelmpl.checkLogin(username, password);
            System.out.println("---登录成功---");

            return "person";
        }catch (Exception e)
        {
            System.out.println("登录失败");
            return "login";
        }

    }

}
