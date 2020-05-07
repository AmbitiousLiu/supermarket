package com.example.supermarket.ws.mapper;

import com.example.supermarket.ws.domain.Stuff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StuffMapper {

    @Select("select * from stuff where stu_num = #{stu_num} and password = #{password}")
    Stuff findStuff(String stu_num,String password);

}
