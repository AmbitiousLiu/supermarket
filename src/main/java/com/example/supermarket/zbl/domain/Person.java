package com.example.supermarket.zbl.domain;

import lombok.Data;
import java.sql.Date;

@Data
public class Person {
    String name ;//员工姓名
    String gender; //性别
    String position;//职位
    String stu_num;//工号
    String region;//所属区域
    Double salary;//工资
    Integer age;//年龄
    Integer seniority;//工龄

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", position='" + position + '\'' +
                ", stu_num='" + stu_num + '\'' +
                ", region='" + region + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", seniority=" + seniority +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStu_num() {
        return stu_num;
    }

    public void setStu_num(String stu_num) {
        this.stu_num = stu_num;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSeniority() {
        return seniority;
    }

    public void setSeniority(Integer seniority) {
        this.seniority = seniority;
    }
}
