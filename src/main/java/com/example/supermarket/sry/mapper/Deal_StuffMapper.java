package com.example.supermarket.sry.mapper;

import com.example.supermarket.sry.domain.Deal_Stuff;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Deal_StuffMapper {
    /**
     * get all commodities
     * @return
     */
    @Select("select * from Stuff")
    List<Deal_Stuff> getAllStufves();

    /**
     * get commodities by the stu_num
     * @param stu_num
     * @return
     */
    @Select("select * from stuff where stu_num = #{stu_num}")
    List<Deal_Stuff> getStufvesByStu_num(String stu_num);


}
