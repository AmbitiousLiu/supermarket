package com.example.supermarket.ych.mapper;

import com.example.supermarket.ych.domain.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    @Select("select region, stu_num, name, work, sign from employee" +
            " where employee.region = #{region}")
    List<Employee>getAllInfo(String region);

    @Select("select distinct region from employee")
    List<Employee>getAllRegion();

    @Insert("insert into employee(region, stu_num, name, work, sign)" +
            " values (#{employee.region}, #{employee.stu_num}, #{employee.name}, #{employee.work}, #{employee.sign})")
    Integer insertInfo(String region, String stu_num, String name, String work, Boolean sign);

    @Delete("delete from employee where stu_num = #{stu_num}")
    Integer deleteInfo(String stu_num);
}