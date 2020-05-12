package com.example.supermarket.zbl.mapper;


import com.example.supermarket.zbl.domain.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PersonMapper {

    @Select("select * from stuff" +
            " where stuff.stu_num = #{useId}")
    List<Person>getAllInfo(String useId);

    @Update("update stuff " +
            "set name = #{name},gender = #{gender},region = #{region}," +
            "position = #{position},age = #{age},password = #{pas}" +
            " where stuff.stu_num = #{stu_num}")
    Integer modifyAllInfo(String name,String gender,String region,String position,String stu_num,Integer age,String pas);

}
