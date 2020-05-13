package com.example.supermarket.lh.mapper;

import com.example.supermarket.lh.domain.Provider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProviderMapper {
        /**
         * get all commodities
         * @return
         */
        @Select("select * from provider")
        List<Provider> getAllProviders();
}
