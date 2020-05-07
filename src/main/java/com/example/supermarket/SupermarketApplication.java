package com.example.supermarket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.supermarket.ljy.mapper")
@MapperScan("com.example.supermarket.lh.mapper")
@MapperScan("com.example.supermarket.sry.mapper")
@MapperScan("com.example.supermarket.ws.mapper")
@MapperScan("com.example.supermarket.ych.mapper")
@MapperScan("com.example.supermarket.zbl.mapper")
public class SupermarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupermarketApplication.class, args);
    }

}
