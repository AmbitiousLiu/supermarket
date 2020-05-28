package com.example.supermarket.ws.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

@Mapper
public interface RoleMapper {
    @Select("select role_name from stuff inner join stuff_role on stuff.stu_num=stuff_role.sid inner join stuff_roles on stuff_role.rid=stuff_roles.role_id where stuff.stu_num=#{stu_num}")
    Set<String> queryRoleNameByStunum(String stu_num);
}
