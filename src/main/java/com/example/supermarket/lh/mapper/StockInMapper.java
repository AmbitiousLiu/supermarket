package com.example.supermarket.lh.mapper;


import com.example.supermarket.lh.domain.StockIn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StockInMapper {

    @Select("select * from stock_in" +
            " where  num = #{num}")
    List<StockIn>getAllInfo(String num);

}
