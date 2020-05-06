package com.example.supermarket.ws.service;

import com.example.supermarket.ws.domain.Stuff;
import com.example.supermarket.ws.mapper.StuffServiceMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Stuffservicelmp {
    @Resource
    StuffServiceMapper Stu;

    public Stuff findStuff(String stu_num, String password) {
        return Stu.findStuff(stu_num,password);

    }
}
