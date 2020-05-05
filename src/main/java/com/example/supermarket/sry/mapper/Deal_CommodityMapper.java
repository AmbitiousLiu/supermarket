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
    @Select("select * from commodity,store where commodity.cnum = #{cnum} and store.cnum = #{cnum}")
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
     * @param name
     * @param sort
     * @param p_date
     * @param safe_date
     * @param price
     * @param sale_count
     */
    @Update("update commodity set name = #{name}, sort = #{sort}, p_date = #{p_date}, safe_date = #{safe_date}, price = #{price}, sale_count = #{sale_count} where cnum = #{cnum}")
    Integer updateCommodityByCnum(String cnum, String name, String sort, Date p_date, Date safe_date, Integer price, Integer sale_count);
}
