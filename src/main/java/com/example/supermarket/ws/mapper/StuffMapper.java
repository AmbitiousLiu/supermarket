package com.example.supermarket.ws.mapper;

import com.example.supermarket.ws.domain.Stuff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StuffMapper {
    @Select("select stu_num,password,name from stuff where stu_num = #{stu_num}")
    Stuff findStuffByStunum(String stu_num);
}
