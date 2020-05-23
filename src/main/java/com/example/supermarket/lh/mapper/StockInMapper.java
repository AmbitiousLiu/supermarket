package com.example.supermarket.lh.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Date;
import java.util.List;

@Mapper
public interface StockInMapper {
    //插入入库表
    @Insert("insert into stock_in(num,pnum,cnum,indate,sum,stu_num,region,p_date,safe_date,price) " +
            "values (#{num},#{pnum},#{cnum},#{indate},#{sum},#{stu_num},#{region},#{p_date},#{safe_date},#{price})")
    Integer addStock(String num, String pnum, String cnum, Date indate, Integer sum,
                     String stu_num,String region,Date p_date,Date safe_date,Integer price);
    //插入库存
    @Insert("insert into stock(cnum,name,region,count,p_date,safe_date,price_in)" +
            " values(#{cnum},#{name},#{region},#{count},#{p_date},#{safe_date},#{price_in})")
    Integer addStore(String cnum,String name,String region,Integer count,
                     Date p_date,Date safe_date,Integer price_in);

    @Select("select * from store where cnum = #{cnum}")
    List<String> queryCnum(String cnum);

    @Update("update store set sum = sum + #{sum} where cnum = #{cnum}")
    Integer updateStore (Integer sum,String cnum);
    //查询商品名
    @Select("select pname from provider_commodity where pnum = #{pnum} and cnum = #{cnum}")
    String queryPname(String pnum,String cnum);
    //查询生产日期
    @Select("select p_date from provider_commodity where pnum = #{pnum} and cnum = #{cnum}")
    Date queryPdate(String pnum,String cnum);
    //查询保质期
    @Select("select safe_date from provider_commodity where pnum = #{pnum} and cnum = #{cnum}")
    Date querySafedate(String pnum,String cnum);
    //查询商品所属区域
    @Select("select safe_date from provider_commodity where pnum = #{pnum} and cnum = #{cnum}")
    String queryRegion(String pnum,String cnum);
    //查询商品进价
    @Select("select price from provider_commodity where pnum = #{pnum} and cnum = #{cnum}")
    Integer queryPrice(String pnum,String cnum);
}
