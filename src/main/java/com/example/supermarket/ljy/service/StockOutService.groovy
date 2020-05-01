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

    initStockOutByPerson(String stu_num) {
        return JSON.toJSONString(stockOutMapper.initStockOutByPerson(stu_num))
    }

    initStockOut() {
        return JSON.toJSONString(stockOutMapper.initStockOut())
    }

    moreStockOutByPerson(String stu_num, int page, int size) {
        int begin = (page - 1) * size
        return JSON.toJSONString(stockOutMapper.MoreStockOutByPerson(stu_num, begin, size))
    }

    moreStockOut(int page, int size) {
        int begin = (page - 1) * size
        return JSON.toJSONString(stockOutMapper.MoreStockOut(begin, size))
    }

    stockOutDetail(String num) {
        return JSON.toJSONString(stockOutMapper.stockOutDetail(num))
    }

}
