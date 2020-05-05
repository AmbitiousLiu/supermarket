package com.example.supermarket.sry.mapper;

import com.example.supermarket.sry.domain.Deal_StockOut;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Deal_StockOutMapper {
    /**
     * get Stock_out_detail by the num
     * @param num
     * @return
     */
    @Select("select * from stock_out where num = #{num}")
    List<Deal_StockOut> getStockOutByNum(String num);
}
