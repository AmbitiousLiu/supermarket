package com.example.supermarket.zbl.mapper;


import com.example.supermarket.zbl.domain.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PersonMapper {
    //查询员工信息
    @Select("select * from stuff ,stuff_role,stuff_roles" +
            " where stuff.stu_num = stuff._role.sid" +
            " and stuff.stu_num = #{useId}")
    List<Person>getAllInfo(String useId);

    //修改员工信息
    @Update("update stuff " +
            "set name = #{name},pid = #{pid}," +
            "age = #{age},seniority = #{seniority}" +
            " where stuff.stu_num = #{stu_num}")
    Integer modifyAllInfo(String name,String seniority,String pid,String stu_num,Integer age);

    //修改账号密码
    @Update("update stuff set password = #{password} where stu_num = #{stu_num}")
    Integer modifyPassword(String stu_num,String password);
    //查询stuff表
    @Select("select * from stuff,role where stuff.rnum = role.rnum order by stuff.rnum desc limit #{begin}, #{size}")
    List<Person>getInfo(Integer begin,Integer size);
    //查询stuff表数据量
    @Select("select count(*) from stuff ")
    Integer getCounts();
    //修改权限
    @Update("update stuff set rnum = #{rnum} where name = #{name}")
    Integer updateRnum(String rnum,String name);
    //查询rnum
    @Select("select rnum from role where rname = #{rname}")
    String queryRnum(String rname);
    //查询姓名
    @Select("select name from stuff")
    List<String> queryName();
}
