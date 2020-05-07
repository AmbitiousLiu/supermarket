package com.example.supermarket.ws.web;

import com.example.supermarket.ws.domain.Stuff;
import com.example.supermarket.ws.service.Stuffservicelmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping(value = "/userLogin")
public class StuffController {
    @Resource
    @Autowired Stuffservicelmp usi;

    @RequestMapping("/doLogin")
   public void stufflogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
       String stu_num= request.getParameter("stu_num");
       String password =request.getParameter("password");
       Stuff stuff = usi.findStuff(stu_num,password);
       if(stuff == null)
       {
           response.sendRedirect("/ws/login.html");
           return;
       }
       // 设置session，方便后续使用
       HttpSession session = request.getSession();
       session.setAttribute("stu_num", stuff.stu_num);
       session.setAttribute("name", stuff.name);
       session.setAttribute("gender", stuff.gender);
       session.setAttribute("age", stuff.age);
       session.setAttribute("seniority", stuff.seniority);
       session.setAttribute("salary", stuff.salary);
       session.setAttribute("position", stuff.position);
       session.setAttribute("region", stuff.region);
       response.sendRedirect("/zbl/supermarket_pcenter.html");
   }
}


