package com.example.supermarket.sry.mapper;

import com.example.supermarket.sry.domain.Deal_Commodity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Deal_CommodityMapper {
    /**
     * get all commodities
     * @return
     */
    @Select("select * from commodity")
    List<Deal_Commodity> getAllCommodities();

    /**
     * get commodities by the sort
     * @param sort
     * @return
     */
    @Select("select * from commodity where sort = #{sort}")
    List<Deal_Commodity> getCommoditiesBySort(String sort);

    /**
     * get commodity by the cnum
     * @param cnum
     * @return one commodity
     */
    @Select("select * from commodity where cnum = #{cnum}")
    Deal_Commodity getCommodityByCnum(String cnum);

    /**
     * delete commodity by the cnum
     * @param  cnum
     */
    @Delete("delete from commodity where cnum = #{cnum}")
    Integer deleteCommodityByCnum(String cnum);

    /**
     * update commodity by the cnum
     * @param cnum
     */
}
