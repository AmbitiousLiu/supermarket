package com.example.supermarket.zbl.mapper;


import com.example.supermarket.zbl.domain.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PersonMapper {
    //查询员工信息
    @Select("select * from stuff,stuff_role,stuff_roles where " +
            "stuff.stu_num = stuff_role.sid and stuff_role.rid = stuff_roles.role_id " +
            "and stu_num = #{useId} order by rid asc limit 0,1")
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
    @Select("select  * from stuff,stuff_role,stuff_roles " +
            "where stuff.stu_num = stuff_role.sid and stuff_role.rid = stuff_roles.role_id " +
            "order by stuff.stu_num desc limit #{begin}, #{size}")
    List<Person>getInfo(Integer begin,Integer size);
    //查询stuff表数据量
    @Select("select count(*) from stuff ")
    Integer getCounts();
    //修改stuff_role表账号对应的权限
    @Update("update stuff_role set rid = #{rnum} where sid = #{sid}")
    Integer updateRnum(Integer rnum,String sid);
    //查询rnum
    @Select("select rnum from role where rname = #{rname}")
    String queryRnum(String rname);
    //查询姓名
    @Select("select name from stuff")
    List<String> queryName();
    //查询账号根据姓名
    @Select("select stu_num from stuff where name = #{name}")
    String queryStunumByName(String name);
}
