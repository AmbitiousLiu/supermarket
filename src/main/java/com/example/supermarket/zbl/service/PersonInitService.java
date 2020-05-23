package com.example.supermarket.zbl.service;

import com.alibaba.fastjson.JSON;
import com.example.supermarket.zbl.domain.Person;
import com.example.supermarket.zbl.mapper.PersonMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PersonInitService {

    @Resource
    PersonMapper personMapper;

    //查询员工信息
    public String getAllInfo(String useId){

        return   JSON.toJSONString(personMapper.getAllInfo(useId));
    }

    //修改员工信息
    public Integer modifyAllInfo(String name,String gender,String pid,String stu_num,Integer age){
        return  personMapper.modifyAllInfo(name,gender,pid,stu_num,age);}

}
