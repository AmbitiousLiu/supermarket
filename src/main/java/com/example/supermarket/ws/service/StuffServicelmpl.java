package com.example.supermarket.ws.service;

import com.example.supermarket.ws.domain.Stuff;
import com.example.supermarket.ws.mapper.StuffMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StuffServicelmpl {

    @Resource
    StuffMapper stuffMapper;

    public Stuff findStuffByStunum(String stu_num) {
        System.out.println(stuffMapper.findStuffByStunum(stu_num));
        return stuffMapper.findStuffByStunum(stu_num);
    }
    public void checkLogin(String username,String password)throws Exception{
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        subject.login(token);

    }
}
