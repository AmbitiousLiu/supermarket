package com.example.supermarket.ych.service;

import com.alibaba.fastjson.JSON;
import com.example.supermarket.ych.domain.Employee;
import com.example.supermarket.ych.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.swing.plaf.basic.BasicOptionPaneUI;

@Service
public class EmployeeInitService {

    @Resource
    EmployeeMapper employeeMapper;

    public String getAllRegion() { return JSON.toJSONString(employeeMapper.getAllRegion()); }

    public String getAllInfo(String region){
        return JSON.toJSONString(employeeMapper.getAllInfo(region));
    }

    public Integer insertInfo(String region, String stu_num, String name, String work, Boolean sign){
        return employeeMapper.insertInfo(region, stu_num, name, work, sign);
    }

    public Integer deleteInfo(String stu_num){
        return employeeMapper.deleteInfo(stu_num);
    }
}
