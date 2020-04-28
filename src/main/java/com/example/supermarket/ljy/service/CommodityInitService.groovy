package com.example.supermarket.ljy.service

import com.alibaba.fastjson.JSON
import com.example.supermarket.ljy.mapper.CommodityMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author jleo
 * @date 2020/4/27
 */
@Service
class CommodityInitService {

    @Autowired CommodityMapper commodityMapper

    /**
     * get data from mybatis by mapper
     * @return json string
     */
    String getAllCommodities() {
        JSON.toJSONString(commodityMapper.getAllCommodities())
    }
}
