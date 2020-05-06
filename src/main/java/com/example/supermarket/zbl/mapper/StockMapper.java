package com.example.supermarket.zbl.mapper;

import org.apache.ibatis.annotations.Insert;
import com.example.supermarket.ljy.domain.Stock_out;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;

@Mapper
public interface StockMapper {
    @Insert("insert into stock_out(num,cnum,outdate,sum,stu_num)" +
            "values (#{num},#{cnum},#{outdate}," +
            "#{sum},#{stu_num})")
    Integer insertStockOut(String num, String cnum,  Date outdate, Integer sum, String stu_num);
}
