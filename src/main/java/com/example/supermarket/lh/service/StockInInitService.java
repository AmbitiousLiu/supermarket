package com.example.supermarket.lh.service;

import com.alibaba.fastjson.JSON;
import com.example.supermarket.lh.domain.StockIn;
import com.example.supermarket.lh.mapper.StockInMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StockInInitService {

    @Resource
    StockInMapper stockInMapper;


    public String getAllInfo(String inNum){

        return   JSON.toJSONString(stockInMapper.getAllInfo(inNum));
    }
}
