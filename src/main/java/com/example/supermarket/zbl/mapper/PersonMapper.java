package com.example.supermarket.zbl.mapper;


import com.example.supermarket.zbl.domain.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PersonMapper {
    //查询员工信息
    @Select("select * from stuff ,role" +
            " where stuff.rnum = role.rnum" +
            " and stuff.stu_num = #{useId}")
    List<Person>getAllInfo(String useId);

    //修改员工信息
    @Update("update stuff " +
            "set name = #{name},pid = #{pid}," +
            "age = #{age},seniority = #{seniority}" +
            " where stuff.stu_num = #{stu_num}")
    Integer modifyAllInfo(String name,String seniority,String pid,String stu_num,Integer age);

    //修改账号密码
    @Update("update stuff set password = #{password} where stu_num = #{stu_num}")
    Integer modifyPassword(String stu_num,String password);
    //查询stuff表
    @Select("select * from stuff,role where stuff.rnum = role.rnum")
    List<Person>getInfo();
    //查询stuff表数据量
    @Select("select count(*) from stuff ")
    Integer getCounts();
}
