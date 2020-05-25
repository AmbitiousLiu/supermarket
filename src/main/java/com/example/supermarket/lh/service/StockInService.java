package com.example.supermarket.lh.service;

import com.alibaba.fastjson.JSON;
import com.example.supermarket.lh.domain.Stock_in;
import com.example.supermarket.lh.mapper.StockInMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
                            String stu_num,String region,Date p_date,String safe_date,Integer price) {
        return stockInMapper.addStock(num, pnum, cnum, indate, sum, stu_num, region, p_date, safe_date, price);
    }
    //插入库存
    public  Integer addStore(String cnum,String name,String region,Integer count,
                             Date p_date,String safe_date,Integer price_in){
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
    public String querySafedate(String pnum,String cnum){
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
    //查询历史入库单
    public List<Stock_in> moreStockIn(Integer page, Integer size)
    {
        int begin = (page - 1) * size;
        return stockInMapper.moreStockIn(begin, size);
    };
    //查询历史入库单根据角色查询
    public List<Stock_in> moreStockInByPerson(String stu_num,Integer page,Integer size){
        int begin = (page - 1) * size;
        return  stockInMapper.moreStockInByPerson(stu_num, begin, size);
    };
    //查询角色号
    public String queryRnum(String stu_num){
        return stockInMapper.queryRnum(stu_num);
    };
    //查询出库单数据数量
    public Integer queryStockInRows(){
        return stockInMapper.queryStockInRows();
    };
    //仓库管理员查询其出库单数量
    public Integer queryStockInRowsByStu(String stu_num){
        return stockInMapper.queryStockInRowsByStu(stu_num);
    };

}
