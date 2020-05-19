package com.example.supermarket.lh.service;

import com.example.supermarket.lh.mapper.StockInMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;

@Service
public class StockInService {

    @Resource
    public StockInMapper stockInMapper;

    public void addStock(String num, String pname, String cnum, Date indate, Integer sum, String stu_num) {
        stockInMapper.addStock(num, pname, cnum, indate, sum, stu_num);
    }

}
