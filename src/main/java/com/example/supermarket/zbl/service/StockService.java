package com.example.supermarket.zbl.service;


import com.alibaba.fastjson.JSON;
import com.example.supermarket.ljy.domain.Stock_out;
import com.example.supermarket.zbl.mapper.StockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;


@Service
public class StockService {
    @Resource
    StockMapper stockMapper;

    public Integer insertStockOut(String num, String cnum, Date date, Integer sum, String stu_num)
    { return  stockMapper.insertStockOut(num,cnum,date,sum,stu_num);};

    public String queryCnum(){return JSON.toJSONString(stockMapper.queryCnum());};

    public Integer querySum(String cnum){return stockMapper.querySum(cnum);};

    public Integer updateSum(String cnum,Integer sum){return stockMapper.updateSum(cnum,sum);};

    public String queryNum(String num){return stockMapper.queryNum(num);};
}
