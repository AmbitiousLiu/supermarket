package com.example.supermarket.lh.mapper;


import com.example.supermarket.lh.domain.ProviderCommodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProviderCommodityMapper {
    //查询商家拥有的商品
    @Select("select * from provider_commodity where pnum = #{pnum}")
    List<ProviderCommodity> getProviderCommodityByPnum(String pnum);
    //根据商品号查找商品详情
    @Select("select * from provider_commodity where cnum = #{cnum}")
    List<ProviderCommodity>getComInfo(String cnum);
}
