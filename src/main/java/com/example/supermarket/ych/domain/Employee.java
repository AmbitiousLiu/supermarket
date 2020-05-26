package com.example.supermarket.ych.domain;

import lombok.Data;

import java.security.SecureRandom;

@Data
public class Employee {
    private String region;  // 区域
    private String stu_num; // 工号
    private String name;    // 员工姓名
    private Integer age;
    private Integer salary;
    private String seniority;
    private String gender;

    public Employee() {
    }

    public Employee(String region, String stu_num, String name, Integer age, Integer salary, String seniority, String gender) {
        this.region = region;
        this.stu_num = stu_num;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.seniority = seniority;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "region='" + region + '\'' +
                ", stu_num='" + stu_num + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", seniority='" + seniority + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStu_num() {
        return stu_num;
    }

    public void setStu_num(String stu_num) {
        this.stu_num = stu_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getSeniority() {
        return seniority;
    }

    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
