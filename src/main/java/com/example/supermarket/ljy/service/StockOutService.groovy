package com.example.supermarket.ljy.service

import com.alibaba.fastjson.JSON
import com.example.supermarket.ljy.domain.Stock_out
import com.example.supermarket.ljy.mapper.StockOutMapper
import org.apache.ibatis.annotations.Select
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.servlet.http.HttpSession

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

    List<Stock_out> moreStockOutByPerson(String stu_num, int page, int size) {
        int begin = (page - 1) * size
        return stockOutMapper.moreStockOutByPerson(stu_num, begin, size)
    }

    List<Stock_out> moreStockOut(int page, int size) {
        int begin = (page - 1) * size
        return stockOutMapper.moreStockOut(begin, size)
    }

    String stockOutDetail(String num, HttpSession session) {
        def stock_out = stockOutMapper.stockOutDetail(num)
        def position = session.getAttribute("position")
        if (position == "总经理" || position == "副总经理") {
            return JSON.toJSONString(stock_out)
        } else {
            if (session.getAttribute("stu_num") == stock_out.stu_num) {
                return JSON.toJSONString(stock_out)
            } else {
                return null
            }
        }

    }
    //查询出库单数据数量
    Integer queryStockoutRows(){
        return stockOutMapper.queryStockoutRows();
    };
    //仓库管理员查询其出库单数量
    Integer queryStockoutRowsByStu(String stu_num){
        return stockOutMapper.queryStockoutRowsByStu(stu_num);
    };

    //查询角色号
    public Integer queryRnum(String stu_num){
        return stockOutMapper.queryRnum(stu_num);
    };
}
