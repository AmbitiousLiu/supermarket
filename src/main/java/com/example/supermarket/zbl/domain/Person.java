package com.example.supermarket.zbl.domain;

import lombok.Data;
import java.sql.Date;

@Data
public class Person {
    String name ;//员工姓名
    String gender; //性别
    String position;//职位
    String stunum;//工号
    String region;//所属区域
    Double salary;//工资
    Integer age;//年龄
    Integer seniority;//工龄

}
