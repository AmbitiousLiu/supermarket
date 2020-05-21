package com.example.supermarket.zbl.service;


import com.alibaba.fastjson.JSON;
import com.example.supermarket.ljy.domain.Stock_out;
import com.example.supermarket.zbl.mapper.StockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;


@Service
public class StockService {
    @Resource
    StockMapper stockMapper;

    //插入出库单
    public Integer insertStockOut(String num, String cnum, Date date, Integer sum, String stu_num) {
        return  stockMapper.insertStockOut(num,cnum,date,sum,stu_num);
    };
    //查询商品号
    public String queryCnum(){
        return JSON.toJSONString(stockMapper.queryCnum());
    };
    //查询商品数
    public Integer querySum(String cnum){
        return stockMapper.querySum(cnum);
    };
    //修改商品数
    public Integer updateSum(String cnum,Integer sum){
        return stockMapper.updateSum(cnum,sum);
    };
    //查询出库单号
    public String queryNum(String num){
        return stockMapper.queryNum(num);
    };
    //查询商品号
    public List<String> queryCnums(){
        return stockMapper.queryCnum();
    }
}
