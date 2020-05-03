package com.example.supermarket.lh.service;

import com.alibaba.fastjson.JSON;
import com.example.supermarket.lh.domain.StockOut;
import com.example.supermarket.lh.mapper.StockOutAddMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StockOutInitService {

    @Resource
    StockOutAddMapper stockOutAddMapper;


    public String getAllInfo(String outNum){
        return   JSON.toJSONString(stockOutAddMapper.getAllInfo(outNum));
    }
}
