package com.example.supermarket.ljy.mapper

import com.example.supermarket.ljy.domain.Stock_out
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

/**
 * @author jleo
 * @date 2020/4/30
 */
@Mapper
interface StockOutMapper {

    @Select("select * from stock_out where stu_num = #{stu_num} order by outdate limit 4")
    List<Stock_out> initStockOutByPerson(String stu_num)

    @Select("select *from stock_out order by outdate limit 4")
    List<Stock_out> initStockOut()

    @Select("select * from stock_out where stu_num = #{stu_num} order by outdate limit #{begin}, #{size}")
    List<Stock_out> moreStockOutByPerson(String stu_num, Integer begin, Integer size)

    @Select("select * from stock_out order by outdate limit #{begin}, #{size}")
    List<Stock_out> moreStockOut(int begin, int size)

    @Select("select * from stock_out where num = #{num}")
    Stock_out stockOutDetail(String num)
}