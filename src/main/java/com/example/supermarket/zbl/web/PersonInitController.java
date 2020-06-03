package com.example.supermarket.zbl.web;

import com.alibaba.fastjson.JSONObject;
import com.example.supermarket.ws.service.StuffServicelmpl;
import com.example.supermarket.zbl.domain.Person;
import com.example.supermarket.zbl.service.PersonInitService;
import org.apache.log4j.Logger;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.spi.LoggingEvent;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/Info")
public class PersonInitController {
    @Autowired PersonInitService personInitService;
    @Resource StuffServicelmpl stuffServicelmpl;
    private static Logger logger = Logger.getLogger(PersonInitController.class);
    LoggingEvent loggingEvent;
    //查询用户信息
    @RequestMapping(value = "/getInfo") void initPerson(HttpServletResponse response, HttpSession session) throws Exception {
//        session.getAttribute("stu_num");
//        System.out.println(session.getAttribute("stu_num").toString());
        String username=session.getAttribute("stu_num").toString();
        String password=session.getAttribute("password").toString();
        stuffServicelmpl.checkLogin(username,password);
        String content = personInitService.getAllInfo(session.getAttribute("stu_num").toString());
        response.setContentType("text/json;charset=utf-8");
        //获得时间
        long time = System.currentTimeMillis();
        Date qdate = new Date(time);
        //插入足迹
        personInitService.insertData(session.getAttribute("stu_num").toString(),"个人中心",qdate);
        logger.info("name:" + session.getAttribute("name".toString()) + " use: " + loggingEvent.getLocationInformation().getMethodName());
        if (content == null){
            logger.error("Get user info failed!");
        } else{
            logger.info("Get user info success!");
        }
        response.getWriter().write(content==null ?"":content);

    }
    //修改用户信息
    @RequestMapping (value = "/modifyInfo") void modifyPerson(HttpServletResponse response, HttpServletRequest request, @RequestParam(value = "name")String name,
                                                              @RequestParam(value = "seniority")String seniority, @RequestParam(value = "age")String age,
                                                              @RequestParam(value = "pid")String pid) throws Exception {

        HttpSession session  = request.getSession();
        session.getAttribute("stu_num");
        //获得账号
        String username=session.getAttribute("stu_num").toString();
        String password=session.getAttribute("password").toString();
        stuffServicelmpl.checkLogin(username,password);

        String stu_num = session.getAttribute("stu_num").toString();
        //修改用户信息
        Integer integer = personInitService.modifyAllInfo(name,seniority,pid,stu_num,Integer.parseInt(age));
        logger.info("name:" + session.getAttribute("name".toString()) + " use: " + loggingEvent.getLocationInformation().getMethodName());
        response.setContentType("text/json;charset=utf-8");
        //返回1则修改成功，0则失败
        if (integer == 0){
            logger.error("Update user info faile!");
        } else{
            logger.info("update user info succuss");
        }
        response.getWriter().write(integer == 0 ?"0":"1");
    }
    //修改密码功能
    @RequestMapping(value = "/modifyPas")
    void modifyPassword(HttpServletResponse response, HttpServletRequest request
            ,@RequestParam(value = "password_new")String password,@RequestParam(value = "password_old")String old) throws Exception {
        HttpSession session  = request.getSession();
        String username=session.getAttribute("stu_num").toString();
        String passwords=session.getAttribute("password").toString();
        stuffServicelmpl.checkLogin(username,passwords);
        session.getAttribute("stu_num");
        //获得账号
        String stu_num = session.getAttribute("stu_num").toString();
        //获得旧密码
        String oldPassword = personInitService.getInfo(stu_num).get(0).getPassword();
        Md5Hash md5Hash =new Md5Hash(old);
        response.setContentType("text/json;charset=utf-8");
        logger.info("name:" + session.getAttribute("name".toString()) + " use: " + loggingEvent.getLocationInformation().getMethodName());
        //如果旧密码验证成功则可以修改密码
        if(md5Hash.toString().equals(oldPassword)){
            Integer integer = personInitService.modifyPassword(stu_num,password);
            logger.info("Update password success!");
            //返回1则修改成功
            response.getWriter().write("1");
        }else {
            //旧密码验证失败则无法修改
            logger.error("Update password false!");
            response.getWriter().write("0");
        }
    }//获得角色表stuff表联查信息
    @RequestMapping(value = "/getRInfo")
    public String getRInfo(HttpServletResponse response,HttpSession session, @RequestParam(value = "limit", required = true) String size,
                           @RequestParam(value = "page", required = true) String page)throws  IOException{


        response.setContentType("text/json;charset=utf-8");
        List<Person> list = personInitService.getInfo(Integer.parseInt(page),Integer.parseInt(size));
        //获得时间
        long time = System.currentTimeMillis();
        Date qdate = new Date(time);
        //插入足迹
        personInitService.insertData(session.getAttribute("stu_num").toString(),"权限管理",qdate);
        logger.info("name:" + session.getAttribute("name".toString()) + " use: " + loggingEvent.getLocationInformation().getMethodName());
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
        HttpSession session = null;
        logger.info("name:" + session.getAttribute("name".toString()) + " use: " + loggingEvent.getLocationInformation().getMethodName());
        response.setContentType("text/json;charset=utf-8");
//        response.getWriter().write(integer);
        return integer;

    }
    @RequestMapping(value = "/getName")
    public void getName (HttpServletResponse response)throws  IOException{
        String content = personInitService.queryName();
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(content==null ?"":content);

    }

}
