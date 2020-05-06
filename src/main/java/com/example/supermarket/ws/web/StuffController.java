package com.example.supermarket.ws.web;

import com.example.supermarket.ws.service.Stuffservicelmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/userLogin")
public class StuffController {
    @Resource
    @Autowired Stuffservicelmp usi;
   public boolean stufflogin(HttpServletRequest request)
   {
       String stu_num= request.getParameter("stu_num");
       String password =request.getParameter("password");
       System.out.println(stu_num);
       if(usi.findStuff(stu_num,password)==null)
       {
           return false;
       }
       return true;
   }
   }


