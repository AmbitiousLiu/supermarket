package com.example.supermarket.ws.domain;

public class Stuff {
    private String stu_num;
    private String password;

    public Stuff(String stu_num, String password) {
        this.stu_num = stu_num;
        this.password = password;
    }

    public Stuff()
    {

    }
    public String getStu_num() {return stu_num;}
    public void setStu_num(String stu_num){this.stu_num = stu_num;}
    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}
}
