package com.example.supermarket.ws.mapper;

import com.example.supermarket.ws.domain.Stuff;
import com.example.supermarket.zbl.domain.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

import java.util.List;

@Mapper
public interface StuffMapper {
    @Select("select * from stuff where stuff.stu_num = #{stu_num} and password = #{password}")
   Stuff findStuff(String stu_num,String password);


}
