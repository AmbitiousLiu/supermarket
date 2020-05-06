package com.example.supermarket.ljy.mapper

import com.example.supermarket.ljy.domain.Commodity
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

/**
 * @author jleo
 * @date 2020/4/27
 */
@Mapper
interface CommodityMapper {

    /**
     * get all commodities
     * @return
     */
    @Select("select * from commodity where shelf_count > 0")
    List<Commodity> getAllCommodities()

    /**
     * get commodities by the sort
     * @param sort
     * @return
     */
    @Select("select * from commodity where sort = #{sort} and shelf_count > 0")
    List<Commodity> getCommoditiesBySort(String sort)

    /**
     * get commodity by the cnum
     * @param cnum
     * @return one commodity
     */
    @Select("select * from commodity where cnum = #{cnum}")
    Commodity getCommodityByCnum(String cnum)

}