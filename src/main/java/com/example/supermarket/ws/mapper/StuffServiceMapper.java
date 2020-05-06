package com.example.supermarket.ws.mapper;

import com.example.supermarket.ws.domain.Stuff;

public interface StuffServiceMapper {
    Stuff findStuff(String stu_num, String password);
}
