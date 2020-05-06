package com.example.supermarket.zbl.service;


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
}
