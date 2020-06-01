package com.example.supermarket.lh.mapper;

import com.example.supermarket.lh.domain.Provider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Mapper
public interface ProviderMapper {
        /**
         * get all providers
         * @return
         */
        @Select("select * from provider")
        List<Provider> getAllProviders();

        /**
         * insert provider
         * @return
         */
        @Insert("insert into provider(pnum,pname,padd,ptel,pmail,trust,cnum,cname) values(#{pnum},#{pname},#{padd},#{ptel},#{pmail},#{trust},#{cnum},#{cname})")
        Integer addProvider(String pnum, String pname, String padd, String ptel, String pmail, String trust, String cnum, String cname);

        //根据商家号查询信息
        @Select("select * from provider where pnum = #{pnum}")
        List<Provider> getProvidersByPnum(String pnum);
        //向用户分析表插入数据
        @Insert("insert into userBehavior values(#{stu_num},#{url},#{qdate})")
        Integer insertData(String stu_num, String url, Date qdate);

}
