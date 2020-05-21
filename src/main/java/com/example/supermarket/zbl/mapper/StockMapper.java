package com.example.supermarket.zbl.mapper;

import org.apache.ibatis.annotations.*;
import com.example.supermarket.ljy.domain.Stock_out;

import java.sql.Date;
import java.util.List;

@Mapper
public interface StockMapper {
    //插入出库单
    @Insert("insert into stock_out(num,cnum,outdate,sum,stu_num)" +
            "values (#{num},#{cnum},#{outdate}," +
            "#{sum},#{stu_num})")
    Integer insertStockOut(String num, String cnum,  Date outdate, Integer sum, String stu_num);

    //查询商品号
    @Select("select cnum from stock_in")
    List<String> queryCnum();

    //查询商品余额
    @Select("select sum from stock_in where cnum = #{cnum}")
    Integer querySum(String cnum);

    //查询商品数量
    @Select("select num from stock_out where num = #{num}")
    String queryNum(String num);

    //修改入库单商品数量
    @Update("update stock_in set sum = #{sum} where cnum = #{cnum}")
    Integer updateSum(String cnum,Integer sum);

    //修改commodity
    @Update("update commodity set stock_count = stock_count + #{sum}")
    Integer updateCom(Integer sum);
}
