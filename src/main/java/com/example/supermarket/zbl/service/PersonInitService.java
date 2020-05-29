package com.example.supermarket.zbl.service;

import com.alibaba.fastjson.JSON;
import com.example.supermarket.zbl.domain.Person;
import com.example.supermarket.zbl.mapper.PersonMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonInitService {

    @Resource
    PersonMapper personMapper;

    //查询员工信息
    public String getAllInfo(String useId){

        return   JSON.toJSONString(personMapper.getAllInfo(useId));
    }
    public List<Person> getInfo(String useId){
        return personMapper.getAllInfo(useId);
    };

    //修改员工信息
    public Integer modifyAllInfo(String name,String seniority,String pid,String stu_num,Integer age){
        return  personMapper.modifyAllInfo(name,seniority,pid,stu_num,age);}

    //修改账号密码
    public Integer modifyPassword(String stu_num,String password){
        return personMapper.modifyPassword(stu_num, password)   ;
    };
    //查询stuff表
    public List<Person>getInfo(Integer page,Integer size){
        Integer begin = (page - 1) * size;
        return personMapper.getInfo(begin,size);
    };
    //查询stuff表数据量
    public Integer getCounts(){
        return  personMapper.getCounts();
    };
    //修改stuff_role表账号对应的权限
    public Integer updateRnum(Integer rnum,String sid){
        return personMapper.updateRnum(rnum, sid);
    };
    //查询rnum
    public String queryRnum(String rname){
        return personMapper.queryRnum(rname);
    };
    //查询姓名
    public String queryName(){
        return JSON.toJSONString(personMapper.queryName());
    };
    //查询账号根据姓名
    public String queryStunumByName(String name){
        return personMapper.queryStunumByName(name);
    };
}
