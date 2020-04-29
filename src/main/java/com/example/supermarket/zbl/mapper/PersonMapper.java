package com.example.supermarket.zbl.mapper;


import com.example.supermarket.zbl.domain.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PersonMapper {

    @Select("select * from supermarket_stuff,supermarket_position" +
            " where supermarket_stuff.stu_num = supermarket_position.stu_num " +
            "and supermarket_stuff.stu_num = #{useId}")
    List<Person>getAllInfo(String useId);

    @Update("update person " +
            "set name = #{person.name},gender = #{person.gender},region = #{person.gender}," +
            "position = #{person.position},stunum = #{person.stunum},birth = #{person.birth}," +
            "emBirth = #{person.emBirth} where stu_num = #{person.stu_num}")
    Integer modifyAllInfo(Person person);

}
