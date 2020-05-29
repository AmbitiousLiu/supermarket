package com.example.supermarket.lh.mapper;

import com.example.supermarket.lh.domain.Stock_in;
import com.example.supermarket.ljy.domain.Stock_out;
import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.util.List;

@Mapper
public interface StockInMapper {
    //插入入库表
    @Insert("insert into stock_in(num,pnum,cnum,indate,sum,stu_num,region,p_date,safe_date,price) " +
            "values (#{num},#{pnum},#{cnum},#{indate},#{sum},#{stu_num},#{region},#{p_date},#{safe_date},#{price})")
    Integer addStock(String num, String pnum, String cnum, Date indate, Integer sum,
                     String stu_num,String region,Date p_date,String safe_date,Integer price);
    //插入库存
    @Insert("insert into stock(cnum,name,region,count,p_date,safe_date,price_in)" +
            " values(#{cnum},#{name},#{region},#{count},#{p_date},#{safe_date},#{price_in})")
    Integer addStore(String cnum,String name,String region,Integer count,
                     Date p_date,String safe_date,Integer price_in);

    @Select("select * from stock where cnum = #{cnum}")
    List<String> queryCnum(String cnum);

    @Update("update stock set count = count + #{sum} where cnum = #{cnum}")
    Integer updateStore (Integer sum,String cnum);
    //查询商品名
    @Select("select cname from provider_commodity where pnum = #{pnum} and cnum = #{cnum}")
    String queryPname(String pnum,String cnum);
    //查询生产日期
    @Select("select p_date from provider_commodity where pnum = #{pnum} and cnum = #{cnum}")
    Date queryPdate(String pnum,String cnum);
    //查询保质期
    @Select("select safe_date from provider_commodity where pnum = #{pnum} and cnum = #{cnum}")
    String querySafedate(String pnum,String cnum);
    //查询商品所属区域
    @Select("select region from provider_commodity where pnum = #{pnum} and cnum = #{cnum}")
    String queryRegion(String pnum,String cnum);
    //查询商品进价
    @Select("select price from provider_commodity where pnum = #{pnum} and cnum = #{cnum}")
    Integer queryPrice(String pnum,String cnum);
    //查询历史入库单
    @Select("select * from stock_in order by indate desc limit #{begin}, #{size}")
    List<Stock_in> moreStockIn(@Param("begin") Integer begin, @Param("size") Integer size);
    //查询历史入库单根据角色查询
    @Select("select * from stock_in where stu_num = #{stu_num} order by indate desc limit #{begin}, #{size}")
    List<Stock_in> moreStockInByPerson(@Param("stu_num") String stu_num, @Param("begin") Integer begin, @Param("size") Integer size);
    //查询角色号
    @Select("select rid from stuff_role where  sid = #{stu_num}  limit 0,1")
    Integer queryRnum(String stu_num);
    //查看出库单数量
    @Select("select count(*) from stock_in")
    Integer queryStockInRows();
    //仓库管理员查询其出库单数量
    @Select("select count(*) from stock_in where stu_num = #{stu_num}")
    Integer queryStockInRowsByStu(String stu_num);
}
