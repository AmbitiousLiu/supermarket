package com.example.supermarket.sry.service;

import com.alibaba.fastjson.JSON;
import com.example.supermarket.sry.mapper.Deal_StuffMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Deal_StuffInitService {
    @Resource
    public Deal_StuffMapper dealStuffMapper;

    /**
     * get data from mybatis by mapper
     * @return json string
     */
    public String getAllStufves() {
        return JSON.toJSONString(dealStuffMapper.getAllStufves());
    }

    public String getStufvesByStu_num(String stu_num) {
        return JSON.toJSONString(dealStuffMapper.getStufvesByStu_num(stu_num));
    }
}
