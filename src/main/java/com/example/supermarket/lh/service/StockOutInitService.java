package com.example.supermarket.lh.service;

import com.alibaba.fastjson.JSON;
import com.example.supermarket.lh.domain.StockOut;
import com.example.supermarket.lh.mapper.StockOutMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StockOutInitService {

    @Resource
    StockOutMapper stockOutMapper;


    public String getAllInfo(String num){
        return   JSON.toJSONString(stockOutMapper.getAllInfo(num));
    }
}
