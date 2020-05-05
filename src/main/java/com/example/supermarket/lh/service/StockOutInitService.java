package com.example.supermarket.lh.service;

import com.alibaba.fastjson.JSON;
import com.example.supermarket.lh.domain.StockOut;
import com.example.supermarket.lh.mapper.StockOutADMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StockOutInitService {

    @Resource
    StockOutADMapper stockOutADMapper;


    public String getAllStockout(String num){
        return   JSON.toJSONString(stockOutADMapper.getAllStockout(num));
    }
    public Integer addStockOut(StockOut stockOut){ return   JSON.toJSONString(stockOutADMapper.addStockOut(stockOut));}
    public String deleteStockOutByNum(String num){ return   JSON.toJSONString(stockOutADMapper.deleteStockOutByNum(num));}
}
