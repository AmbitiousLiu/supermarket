package com.example.supermarket.sry.service;

import com.alibaba.fastjson.JSON;
import com.example.supermarket.sry.mapper.DealMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jleo
 * @date 2020/4/27
 */
@Service
public class DealInitService {

    @Resource
    public DealMapper dealMapper;

    /**
     * get data from mybatis by mapper
     * @return json string
     */
    public String getAllCommodities() {
        return JSON.toJSONString(dealMapper.getAllCommodities());
    }

    public String getCommoditiesBySort(String sort) {
        return JSON.toJSONString(dealMapper.getCommoditiesBySort(sort));
    }
    
    public String getCommodityByCnum(String cnum) {
        return JSON.toJSONString(dealMapper.getCommodityByCnum(cnum));
    }
}
