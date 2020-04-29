package com.example.supermarket.sry.mapper;

import com.example.supermarket.sry.domain.Deal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author jleo
 * @date 2020/4/28
 */
@Mapper
public interface DealMapper {
    /**
     * get all commodities
     * @return
     */
    @Select("select * from commodity")
    List<Deal> getAllCommodities();

    /**
     * get commodities by the sort
     * @param sort
     * @return
     */
    @Select("select * from commodity where sort = #{sort}")
    List<Deal> getCommoditiesBySort(String sort);

    /**
     * get commodity by the cnum
     * @param cnum
     * @return one commodity
     */
    @Select("select * from commodity where cnum = #{cnum}")
    Deal getCommodityByCnum(String cnum);
}
