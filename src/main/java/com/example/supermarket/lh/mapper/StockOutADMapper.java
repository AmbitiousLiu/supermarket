package com.example.supermarket.lh.mapper;


import com.example.supermarket.lh.domain.StockOut;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

@Mapper
public interface StockOutADMapper {

    @Select("select * from StockOut")
    List<StockOut> getAllStockout(String num);

    @Insert({"insert into StockOut values(#{num},#{pname},#{cnum},#{outdate},#{price},#{sum},#{stu_num})"})
    @SelectKey(statement = "select last_insert_id()",keyProperty = "num",keyColumn = "num",before = false,resultType = Integer.class)
    Integer addStockOut(StockOut stockOut);

    @Delete("delete from StockOut where num = #{num}")
    Integer deleteStockOutByNum(String num);

}
