package com.example.supermarket.lh.mapper;


import com.example.supermarket.lh.domain.StockOut;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StockOutAddMapper {

    @Select("select * from stock_out" +
            " where  num = #{outNum} ")
    List<StockOut>getAllInfo(String outNum);

}
