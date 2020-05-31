package com.example.supermarket.zbl.mapper;

import com.example.supermarket.zbl.domain.DateSum;
import com.example.supermarket.zbl.domain.FootPrints;
import com.example.supermarket.zbl.domain.Url;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FootPrintsMapper {
    //查询足迹所有信息
    @Select("select * from userbehavior where stu_num = #{stu_num} order by qdate limit #{begin},#{limit}")
    List<FootPrints> queryPrints(String stu_num,Integer begin,Integer limit);
    //查询该用户的足迹信息条数
    @Select("select count(*) from userbehavior where stu_num = #{stu_num} ")
    Integer queryRows(String stu_num);
    //统计用户url各访问情况
    @Select("select url name, count(*)value from userbehavior where stu_num =#{stu_num} group by url")
    List<Url> queryUrl(String stu_num);
    //统计最近七天访问次数
    @Select("select * from (select qdate date ,count(*) count from userbehavior where stu_num = #{stu_num} group by qdate desc limit 0,7) as a order by date asc")
    List<DateSum> queryDate(String stu_num);
}
