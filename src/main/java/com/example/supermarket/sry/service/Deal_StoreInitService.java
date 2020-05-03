package com.example.supermarket.sry.service;

import com.alibaba.fastjson.JSON;
import com.example.supermarket.sry.mapper.Deal_StoreMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Deal_StoreInitService {
    @Resource
    public Deal_StoreMapper dealStoreMapper;

    public String getStoreByCnum(String cnum){
        return JSON.toJSONString(dealStoreMapper.getStoreByCnum(cnum));
    }
}
