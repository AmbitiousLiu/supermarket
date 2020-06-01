package com.example.supermarket.sry.mapper;

import com.example.supermarket.sry.domain.Deal_Commodity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Date;
import java.util.List;

@Mapper
public interface Deal_CommodityMapper {
    /**
     * get all commodities
     * @return
     */
    @Select("select * from shelf")
    List<Deal_Commodity> getAllCommodities();

    /**
     * get commodity by the cnum
     * @param cnum
     * @return one commodity
     */
    @Select("select * from shelf where cnum = #{cnum}")
    Deal_Commodity getCommodityByCnum(String cnum);

    /**
     * delete commodity by the cnum
     * @param  cnum
     */
    @Delete("delete from shelf where cnum = #{cnum}")
    Integer deleteCommodityByCnum(String cnum);

    /**
     * update commodity by the cnum
     * @param cnum
     * @param name
     * @param price_out
     */
    @Update("update shelf set name = #{name}, price_out = #{price_out} where cnum = #{cnum}")
    Integer updateCommodityByCnum(String cnum, String name, Integer price_out);
}
