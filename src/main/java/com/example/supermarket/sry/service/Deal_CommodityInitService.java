package com.example.supermarket.sry.service;

import com.alibaba.fastjson.JSON;
import com.example.supermarket.sry.mapper.Deal_CommodityMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import redis.clients.jedis.Jedis;
import java.sql.Date;

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
    
    public String getCommodityByCnum(String cnum) {

        return JSON.toJSONString(dealCommodityMapper.getCommodityByCnum(cnum));
    }

    public String deleteCommodityByCnum(String cnum){
        return JSON.toJSONString(dealCommodityMapper.deleteCommodityByCnum(cnum));
    }

    public String updateCommodityByCnum(String cnum, String name, Integer price_out){
        return JSON.toJSONString(dealCommodityMapper.updateCommodityByCnum(cnum, name, price_out));
    }
}
