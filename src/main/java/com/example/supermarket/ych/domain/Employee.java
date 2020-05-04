package com.example.supermarket.ych.domain;

import lombok.Data;

import java.security.SecureRandom;

@Data
public class Employee {
    String region;  // 区域
    String stu_num; // 工号
    String name;    // 员工姓名
    String work;    // 员工工作
    Boolean sign;   // 员工是否签到

    @Override
    public String toString() {
        return "Employee{" +
                "region='" + region + '\'' +
                ", stu_num='" + stu_num + '\'' +
                ", name='" + name + '\'' +
                ", work='" + work + '\'' +
                ", sign='" + sign +
                '}';
    }

    public String getRegion() { return region; }

    public void setRegion(String region) { this.region = region; }

    public String getStu_num() { return stu_num; }

    public void setStu_num(String stu_num) { this.stu_num = stu_num; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String setWork() { return work; }

    public void setWork(String work) { this.work = work; }

    public Boolean getSign() { return sign; }

    public void setSign(Boolean sign) { this.sign = sign; }
}
