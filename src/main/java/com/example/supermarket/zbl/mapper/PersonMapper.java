package com.example.supermarket.zbl.mapper;


import com.example.supermarket.zbl.domain.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PersonMapper {

    @Select("select * from supermarket_stuff,supermarket_user,supermarket_position" +
            " where supermarket_stuff.stu_num = supermarket_user.stu_num " +
            "and supermarket_stuff.position = supermarket_position.position " +
            "and useId = #{useId}")
    List<Person>getAllInfo();

    @Update("update person " +
            "set name = #{name},gender = #{gender},region = #{gender}," +
            "position = #{position},stunum = #{stunum},birth = #{birth}," +
            "emBirth = #{emBirth} where useId = #{useId}")
    Integer modifyAllInfo();

}
