package com.example.supermarket.sry.service;

import com.alibaba.fastjson.JSON;
import com.example.supermarket.sry.mapper.Deal_CommodityMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    public String getCommoditiesBySort(String sort) {
        return JSON.toJSONString(dealCommodityMapper.getCommoditiesBySort(sort));
    }
    
    public String getCommodityByCnum(String cnum) {
        return JSON.toJSONString(dealCommodityMapper.getCommodityByCnum(cnum));
    }

    public String deleteCommodityByCnum(String cnum){
        return JSON.toJSONString(dealCommodityMapper.deleteCommodityByCnum(cnum));
    }

    public String updateCommodityByCnum(String cnum, String name, String sort, Date p_date, Date safe_date, Integer price, Integer sale_count){
        return JSON.toJSONString(dealCommodityMapper.updateCommodityByCnum(cnum, sort, name, p_date, safe_date, price, sale_count));
    }
}
