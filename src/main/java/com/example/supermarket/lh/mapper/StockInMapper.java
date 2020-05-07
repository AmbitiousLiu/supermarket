package com.example.supermarket.lh.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Date;

@Mapper
public interface StockInMapper {

    @Insert("insert into stock_in(num,pname,cnum,indate,sum,stu_num)" +
            "values (#{num},#{pname},#{cnum},#{indate}," +
            "#{sum},#{stu_num})")
    Integer addStock(String num, String pname, String cnum, Date indate, int sum, String stu_num);

}
