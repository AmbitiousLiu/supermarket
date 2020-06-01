package com.example.supermarket.zbl.domain;

import lombok.Data;
import java.sql.Date;

@Data
public class Person {
    private String name ;//员工姓名
    private String gender; //性别
    private String role_name;//角色
    private String stu_num;//工号
    private String region;//所属区域
    private Double salary;//工资
    private Integer age;//年龄
    private Integer seniority;//工龄
    private String password;//密码
    private String pid;//身份证号

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", role_name='" + role_name + '\'' +
                ", stu_num='" + stu_num + '\'' +
                ", region='" + region + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", seniority=" + seniority +
                ", password='" + password + '\'' +
                ", pid='" + pid + '\'' +
                '}';
    }

    public Person(String name, String gender, String role_name, String stu_num, String region, Double salary, Integer age, Integer seniority, String password, String pid) {
        this.name = name;
        this.gender = gender;
        this.role_name = role_name;
        this.stu_num = stu_num;
        this.region = region;
        this.salary = salary;
        this.age = age;
        this.seniority = seniority;
        this.password = password;
        this.pid = pid;
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

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
