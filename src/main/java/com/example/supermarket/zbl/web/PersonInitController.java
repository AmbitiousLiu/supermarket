package com.example.supermarket.zbl.web;

import com.alibaba.fastjson.JSONObject;
import com.example.supermarket.ljy.domain.Commodity;
import com.example.supermarket.zbl.domain.Person;
import com.example.supermarket.zbl.service.PersonInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/Info")
public class PersonInitController {
    @Autowired PersonInitService personInitService;

    //查询用户信息
    @RequestMapping(value = "/getInfo") void initPerson(HttpServletResponse response, HttpSession session)throws IOException {
        session.setAttribute("stu_num","10001");
//        System.out.println(session.getAttribute("stu_num").toString());
        String content = personInitService.getAllInfo(session.getAttribute("stu_num").toString());
        response.setContentType("text/json;charset=utf-8");
//        personInitService.insertData()
//        System.out.println(content);
        response.getWriter().write(content==null ?"":content);

    }
    //修改用户信息
    @RequestMapping (value = "/modifyInfo") void modifyPerson(HttpServletResponse response, HttpServletRequest request, @RequestParam(value = "name")String name,
                                                              @RequestParam(value = "seniority")String seniority, @RequestParam(value = "age")String age,
                                                              @RequestParam(value = "pid")String pid)throws IOException{

        HttpSession session  = request.getSession();
        session.setAttribute("stu_num","10001");
        //获得账号
        String stu_num = session.getAttribute("stu_num").toString();
        //修改用户信息
        Integer integer = personInitService.modifyAllInfo(name,seniority,pid,stu_num,Integer.parseInt(age));
//        System.out.println(integer);
        response.setContentType("text/json;charset=utf-8");
        //返回1则修改成功，0则失败
        response.getWriter().write(integer == 0 ?"0":"1");
//        response.sendRedirect("/zbl/person_change.html");
    }
    //修改密码功能
    @RequestMapping(value = "/modifyPas")
    void modifyPassword(HttpServletResponse response, HttpServletRequest request
            ,@RequestParam(value = "password_new")String password,@RequestParam(value = "password_old")String old)throws IOException{
        HttpSession session  = request.getSession();
        session.setAttribute("stu_num","10001");
        //获得账号
        String stu_num = session.getAttribute("stu_num").toString();
        //获得旧密码
        String oldPassword = personInitService.getInfo(stu_num).get(0).getPassword();

        response.setContentType("text/json;charset=utf-8");
        //如果旧密码验证成功则可以修改密码
        if(old.equals(oldPassword)){
            Integer integer = personInitService.modifyPassword(stu_num,password);
            //返回1则修改成功
            response.getWriter().write("1");
        }else {
            //旧密码验证失败则无法修改
            response.getWriter().write("0");
        }
    }//获得角色表stuff表联查信息
    @RequestMapping(value = "/getRInfo")
    public String getRInfo(HttpServletResponse response, @RequestParam(value = "limit", required = true) String size,
                           @RequestParam(value = "page", required = true) String page)throws  IOException{
        response.setContentType("text/json;charset=utf-8");
        List<Person> list = personInitService.getInfo(Integer.parseInt(page),Integer.parseInt(size));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0 );
        jsonObject.put("msg","");
        jsonObject.put("count",personInitService.getCounts());
        jsonObject.put("data",list);
        return  jsonObject.toString();
    }//根据姓名修改权限
    @RequestMapping(value = "/updateRInfo")
    public Integer updateRInfo (HttpServletResponse response, @RequestParam(value = "condition", required = true) String name,
                                                   @RequestParam(value = "role", required = true) String rnum)throws  IOException {

//        System.out.println(rname);
//        String rnum = personInitService.queryRnum(rname);
        //根据姓名查询账号sid
        String sid = personInitService.queryStunumByName(name) ;
        //修改stuff_role表账号权限信息
        Integer integer = personInitService.updateRnum(Integer.parseInt(rnum),sid);
        response.setContentType("text/json;charset=utf-8");
//        response.getWriter().write(integer);
        return integer;

    }
    @RequestMapping(value = "/getName")
    public void getName (HttpServletResponse response)throws  IOException{
        String content = personInitService.queryName();
        response.setContentType("text/json;charset=utf-8");
        System.out.println(content);
        response.getWriter().write(content==null ?"":content);

    }

}
