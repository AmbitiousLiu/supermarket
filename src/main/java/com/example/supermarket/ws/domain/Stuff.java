package com.example.supermarket.ws.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Stuff implements Serializable {
    private String stu_num;
    private String password;


    public String getUsername()
    {
        return stu_num;
    }
    public String getPassword()
    {
        return password;
    }





}