package com.example.supermarket.ljy.mapper

import com.example.supermarket.ljy.domain.Commodity
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

import java.sql.Date

/**
 * @author jleo
 * @date 2020/4/27
 */
@Mapper
interface CommodityMapper {

    /**
     * get all commodities from shelf
     * @return
     */
    @Select("select * from shelf where count > 0")
    List<Commodity> getAllCommodities()

    /**
     * get commodities by the sort from shelf
     * @param sort
     * @return
     */
    @Select("select * from shelf where region = #{region} and count > 0")
    List<Commodity> getCommoditiesBySort(String region)

    /**
     * get commodity by the cnum from shelf
     * @param cnum
     * @return one commodity
     */
    @Select("select * from shelf where cnum = #{cnum}")
    Commodity getCommodityByCnum(String cnum)
    //向用户分析表插入数据
    @Insert("insert into userBehavior values(#{stu_num},#{url},#{qdate})")
    Integer insertData(@Param("stu_num")String stu_num, @Param("url")String url, @Param("qdate")Date qdate)
}