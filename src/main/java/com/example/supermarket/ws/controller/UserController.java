package com.example.supermarket.ws.controller;

import com.example.supermarket.ws.domain.Stuff;
import com.example.supermarket.ws.service.StuffServicelmpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("user")
public class UserController extends HttpServlet {//登录验证
    @Resource
    private StuffServicelmpl stuffServicelmpl;

    @RequestMapping("login")
    public String login(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
            HttpSession session =request.getSession();
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            Stuff stuff=stuffServicelmpl.findStuffByStunum(username);
        try {
            stuffServicelmpl.checkLogin(username, password);
            System.out.println("---登录成功---");
                session.setAttribute("stu_num",username);
                session.setAttribute("password",password);
                session.setAttribute("name",stuff.getName());

            return "../static/zbl/person";
        }catch (Exception e)
        {
            System.out.println("登录失败");
            return "error";
        }

    }

}
