package com.example.supermarket.zbl.service;


import com.alibaba.fastjson.JSON;

import com.example.supermarket.zbl.mapper.StockMapper;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;


@Service
public class StockService {
    @Resource
    StockMapper stockMapper;

    //插入出库单
    public Integer insertStockOut(String num, String cnum,  Date outdate, Integer sum, String stu_num,String region,
                                  String name,String cname) {
        return  stockMapper.insertStockOut(num, cnum, outdate, sum, stu_num, region, name, cname);
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
    //修改commodity
    public Integer updateCom(Integer sum,String cnum,Integer price){return stockMapper.updateCom(sum,cnum,price);}
    //查询商品进价
    public Integer queryPrice(String num){
        return stockMapper.queryPrice(num);
    };
    //新增架上商品
    public Integer addCommodity(String cnum,String name,String region,Date p_date,String safe_date,Integer price_out,Integer count){
        return stockMapper.addCommodity(cnum, name, region, p_date, safe_date,price_out, count);
    };
    //查询架上商品商品号
    public String queryShelfcnum(String cnum){
        return stockMapper.queryShelfcnum(cnum);
    };
    //查询商品名
    public String queryName(String cnum){
        return stockMapper.queryName(cnum);
    };
    //查询生产日期
    public Date queryPdate(String cnum){
        return stockMapper.queryPdate( cnum);
    };
    //查询保质期
    public String querySafedate(String cnum){
        return stockMapper.querySafedate(cnum);
    }
    //查询出库单数据数量
    public Integer queryStockoutRows(){
        return stockMapper.queryStockoutRows();
    };
    //仓库管理员查询其出库单数量
    public Integer queryStockoutRowsByStu(String stu_num){
        return stockMapper.queryStockoutRowsByStu(stu_num);
    };
    //查询角色号
    public String queryRnum(String stu_num){
        return stockMapper.queryRnum(stu_num);
    };
    //查询库存
    public String queryStock(){
        return JSON.toJSONString(stockMapper.queryStock());
    };
    //查询库存详情根据商品号
    public String queryStockByCnum(String cnum){
        return JSON.toJSONString(stockMapper.queryStockByCnum(cnum));
    };

}
