package com.example.supermarket.zbl.service;

import com.alibaba.fastjson.JSON;
import com.example.supermarket.zbl.domain.Person;
import com.example.supermarket.zbl.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PersonInitService {

    @Resource
    PersonMapper personMapper;


    public String getAllInfo(String useId){
       return   JSON.toJSONString(personMapper.getAllInfo(useId));
    }
    public Integer modifyAllInfo(Person person){ return  personMapper.modifyAllInfo(person);}

}
