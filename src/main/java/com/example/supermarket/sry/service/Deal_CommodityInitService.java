package com.example.supermarket.sry.service;

import com.alibaba.fastjson.JSON;
import com.example.supermarket.sry.mapper.Deal_CommodityMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Deal_CommodityInitService {

    @Resource
    public Deal_CommodityMapper dealCommodityMapper;

    /**
     * get data from mybatis by mapper
     * @return json string
     */
    public String getAllCommodities() {
        return JSON.toJSONString(dealCommodityMapper.getAllCommodities());
    }

    public String getCommoditiesBySort(String sort) {
        return JSON.toJSONString(dealCommodityMapper.getCommoditiesBySort(sort));
    }
    
    public String getCommodityByCnum(String cnum) {
        return JSON.toJSONString(dealCommodityMapper.getCommodityByCnum(cnum));
    }
}
