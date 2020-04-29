package com.example.supermarket.lh.mapper;


import com.example.supermarket.lh.domain.StockOut;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StockOutMapper {

    @Select("select * from stock_in" +
            " where  num = #{num} ")
    List<StockOut>getAllInfo(String num);

}
