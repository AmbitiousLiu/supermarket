package com.example.supermarket.sry.service;

import com.alibaba.fastjson.JSON;
import com.example.supermarket.sry.mapper.Deal_StockOutMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Deal_StockOutInitService {
    @Resource public Deal_StockOutMapper deal_StockOutMapper;

    public String getStockOutByNum(String num){
        return JSON.toJSONString(deal_StockOutMapper.getStockOutByNum(num));
    }
}
