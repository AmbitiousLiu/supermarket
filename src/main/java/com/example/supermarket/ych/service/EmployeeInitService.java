package com.example.supermarket.ych.service;

import com.alibaba.fastjson.JSON;
import com.example.supermarket.ych.domain.Employee;
import com.example.supermarket.ych.mapper.EmployeeMapper;
import com.example.supermarket.zbl.domain.Person;
import com.example.supermarket.zbl.mapper.PersonMapper;

import javax.annotation.Resource;

public class EmployeeInitService {

    @Resource
    EmployeeMapper employeeMapper;

    public String getAllInfo(String region){
        return JSON.toJSONString(employeeMapper.getAllInfo(region));
    }

    public Integer modifyAllInfo(Employee employee){ return employeeMapper.modifyAllInfo(employee);}
}
