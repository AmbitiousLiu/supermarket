package com.example.supermarket.ws.service;

import com.example.supermarket.ws.domain.Stuff;
import com.example.supermarket.ws.mapper.StuffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Stuffservicelmp {

    @Resource
    StuffMapper stuffMapper;

    public Stuff findStuff(String stu_num, String password) {
        return stuffMapper.findStuff(stu_num,password);
    }
}
