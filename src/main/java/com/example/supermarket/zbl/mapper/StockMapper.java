package com.example.supermarket.zbl.mapper;

import org.apache.ibatis.annotations.*;
import com.example.supermarket.ljy.domain.Stock_out;

import java.sql.Date;
import java.util.List;

@Mapper
public interface StockMapper {
    @Insert("insert into stock_out(num,cnum,outdate,sum,stu_num)" +
            "values (#{num},#{cnum},#{outdate}," +
            "#{sum},#{stu_num})")
    Integer insertStockOut(String num, String cnum,  Date outdate, Integer sum, String stu_num);

    @Select("select cnum from stock_in")
    List<String> queryCnum();

    @Select("select sum from stock_in where cnum = #{cnum}")
    Integer querySum(String cnum);

    @Select("select num from stock_out where num = #{num}")
    String queryNum(String num);

    @Update("update stock_in set sum = #{sum} where cnum = #{cnum}")
    Integer updateSum(String cnum,Integer sum);
}
