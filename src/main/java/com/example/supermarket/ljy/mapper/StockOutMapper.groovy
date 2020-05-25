package com.example.supermarket.ljy.mapper

import com.example.supermarket.ljy.domain.Stock_out
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

/**
 * @author jleo
 * @date 2020/4/30
 */
@Mapper
interface StockOutMapper {

    @Select("select * from stock_out where stu_num = #{stu_num} order by outdate desc limit 4")
    List<Stock_out> initStockOutByPerson(String stu_num)

    @Select("select *from stock_out order by outdate desc limit 1")
    List<Stock_out> initStockOut()

    @Select("select * from stock_out where stu_num = #{stu_num} order by outdate desc limit #{begin}, #{size}")
    List<Stock_out> moreStockOutByPerson(@Param("stu_num") String stu_num, @Param("begin") Integer begin, @Param("size") Integer size)

    @Select("select * from stock_out order by outdate desc limit #{begin}, #{size}")
    List<Stock_out> moreStockOut(@Param("begin") Integer begin, @Param("size") Integer size)

    @Select("select * from stock_out where num = #{num}")
    Stock_out stockOutDetail(String num)
    //查看出库单数量
    @Select("select count(*) from stock_out")
    Integer queryStockoutRows();
    //仓库管理员查询其出库单数量
    @Select("select count(*) from stock_out where stu_num = #{stu_num}")
    Integer queryStockoutRowsByStu(String stu_num);
}