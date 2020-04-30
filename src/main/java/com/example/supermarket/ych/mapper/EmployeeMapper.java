package com.example.supermarket.ych.mapper;

import com.example.supermarket.ych.domain.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    @Select("select employee_num, employee_name, employee_work, employee_sign from supermarket_employee" +
            " where supermarket_stuff.region = #{region}")
    List<Employee>getAllInfo(String region);

    @Insert("insert into employee_info (employee_num,employee_name,employee_work,employee_sign)" +
            " values (#{employee.epe_num},#{employee.epe_name},#{employee.epe_work,employee_sign})")

    @Delete("delete from employee_info where employee_num = #{employee.epe_num}")
    Integer modifyAllInfo(Employee employee);
}