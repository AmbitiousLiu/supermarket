package com.example.supermarket.ljy.service

import com.alibaba.fastjson.JSON

import com.example.supermarket.ljy.mapper.StockOutMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author jleo
 * @date 2020/4/30
 */
@Service
class StockOutService {

    @Autowired StockOutMapper stockOutMapper

    String initStockOutByPerson(String stu_num) {
        return JSON.toJSONString(stockOutMapper.initStockOutByPerson(stu_num))
    }

    String initStockOut() {
        return JSON.toJSONString(stockOutMapper.initStockOut())
    }

    String moreStockOutByPerson(String stu_num, int page, int size) {
        int begin = (page - 1) * size
        return JSON.toJSONString(stockOutMapper.moreStockOutByPerson(stu_num, begin, size))
    }

    String moreStockOut(int page, int size) {
        int begin = (page - 1) * size
        return JSON.toJSONString(stockOutMapper.moreStockOut(begin, size))
    }

    String stockOutDetail(String num) {
        return JSON.toJSONString(stockOutMapper.stockOutDetail(num))
    }

}
