package com.example.supermarket.ljy.service

import com.alibaba.fastjson.JSON
import com.example.supermarket.ljy.mapper.CommodityMapper
import org.apache.ibatis.annotations.Insert
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.sql.Date

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

    String getCommoditiesBySort(String sort) {
        JSON.toJSONString(commodityMapper.getCommoditiesBySort(sort))
    }

    String getCommodityByCnum(String cnum) {
        JSON.toJSONString(commodityMapper.getCommodityByCnum(cnum))
    }
    //向用户分析表插入数据
    Integer insertData(String stu_num, String url, Date qdate){
        return commodityMapper.insertData(stu_num,url,qdate);
    }
}
