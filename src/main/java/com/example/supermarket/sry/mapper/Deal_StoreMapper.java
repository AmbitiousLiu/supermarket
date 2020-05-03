package com.example.supermarket.sry.mapper;

import com.example.supermarket.sry.domain.Deal_Store;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Deal_StoreMapper {

    /**
     * get store by the cnum
     * @param sort
     * @return
     */
    @Select("select sum from store where cnum = #{cnum}")
    List<Deal_Store> getStoreByCnum(String cnum);
}
