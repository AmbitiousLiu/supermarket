package com.example.supermarket.ych.mapper;

import com.example.supermarket.ych.domain.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper {
//根据分区查询员工信息
    @Select("select * employee" +
            " where employee.region = #{region}")
    List<Employee>getAllInfo(String region);
//查询分区
    @Select("select distinct region from employee")
    List<Employee>getAllRegion();
//插入雇员信息
    @Insert("insert into employee(region, stu_num, name,gender,seniority,salary,age)" +
            " values (#{region}, #{stu_num}, #{name}, #{gender}, #{seniority},#{salary},#{age})")
    Integer insertInfo(String region, String stu_num, String name, String gender,String seniority,Integer salary,Integer age);
//删除员工信息
    @Delete("delete from employee where stu_num = #{stu_num}")
    Integer deleteInfo(String stu_num);
    //查询所有员工信息
    @Select("select * from employee order by stu_num desc limit #{begin}, #{size}")
    List<Employee> queryInfo(Integer begin,Integer size);
    //查询雇员表数据量
    @Select("select count(*) from employee")
    Integer queryCounts();
}