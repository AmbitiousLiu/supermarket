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
            "set name = #{person.name},gender = #{person.gender},region = #{person.gender}," +
            "position = #{person.position},stu_num = #{person.stunum}" +
            " where stu_num = #{person.stu_num}")
    Integer modifyAllInfo(Person person);

}
