package com.example.supermarket.ych.service;

import com.alibaba.fastjson.JSON;
import com.example.supermarket.ych.domain.Employee;
import com.example.supermarket.ych.mapper.EmployeeMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.sql.Date;
import java.util.List;

@Service
public class EmployeeInitService {

    @Resource
    EmployeeMapper employeeMapper;

    public String getAllRegion() { return JSON.toJSONString(employeeMapper.getAllRegion()); }

    public String getAllInfo(String region){
        return JSON.toJSONString(employeeMapper.getAllInfo(region));
    }

    public  Integer insertInfo(String region, String stu_num, String name, String gender,String seniority,Integer salary,Integer age)
    {
        return employeeMapper.insertInfo(region, stu_num, name, gender, seniority, salary, age);
    }

    public Integer deleteInfo(String stu_num){
        return employeeMapper.deleteInfo(stu_num);
    }
    //查询所有雇员信息
    public List<Employee> queryInfo(Integer page , Integer size){
        Integer begin = (page - 1) * size;
        return employeeMapper.queryInfo(begin,size);
    }
    //查询雇员表数据量
    public Integer queryCounts(){
        return employeeMapper.queryCounts();
    };
    //向用户分析表插入数据
    public Integer insertData(String stu_num, String url, Date qdate){
        return employeeMapper.insertData(stu_num, url, qdate);
    };
}
