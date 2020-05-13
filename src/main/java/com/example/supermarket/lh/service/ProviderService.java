package com.example.supermarket.lh.service;

import com.alibaba.fastjson.JSON;
import com.example.supermarket.lh.mapper.ProviderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProviderService {

    @Resource
    public ProviderMapper providerMapper;

    public String getAllProviders() {
        return JSON.toJSONString(providerMapper.getAllProviders());
    }
}
