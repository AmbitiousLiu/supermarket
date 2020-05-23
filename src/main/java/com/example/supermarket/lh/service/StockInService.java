package com.example.supermarket.lh.service;

import com.alibaba.fastjson.JSON;
import com.example.supermarket.lh.mapper.StockInMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;

@Service
public class StockInService {

    @Resource
    public StockInMapper stockInMapper;
    //添加入库表
    public Integer addStock(String num, String pnum, String cnum, Date indate, Integer sum,
                            String stu_num,String region,Date p_date,Date safe_date,Integer price) {
        return stockInMapper.addStock(num, pnum, cnum, indate, sum, stu_num, region, p_date, safe_date, price);
    }
    //插入库存
    public  Integer addStore(String cnum,String name,String region,Integer count,
                             Date p_date,Date safe_date,Integer price_in){
        return stockInMapper.addStore(cnum, name, region, count, p_date, safe_date, price_in);
    }
    //查询库存是否有该商品
    public List<String> queryCnum(String cnum){
        return stockInMapper.queryCnum(cnum);
    };
    //更新库存相应的商品数量
    public Integer updateStore (Integer sum,String cnum){
        return  stockInMapper.updateStore(sum, cnum);
    };

    //查询商品名
    public String queryPname(String pnum,String cnum){
        return stockInMapper.queryPname(pnum, cnum);
    }
    //查询生产日期
    public Date queryPdate(String pnum,String cnum){
        return stockInMapper.queryPdate(pnum, cnum);
    };
    //查询保质期
    public Date querySafedate(String pnum,String cnum){
        return stockInMapper.querySafedate(pnum, cnum);
    }
    //查询商品所属区域
    public String queryRegion(String pnum,String cnum){
        return stockInMapper.queryRegion(pnum, cnum);
    }
    //查询商品进价
    public Integer queryPrice(String pnum,String cnum){
        return stockInMapper.queryPrice(pnum, cnum);
    }
}
