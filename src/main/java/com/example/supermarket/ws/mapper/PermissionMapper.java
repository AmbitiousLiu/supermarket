package com.example.supermarket.ws.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

@Mapper
public interface PermissionMapper {
    @Select("select stuff_permissions.permission_code from stuff inner join stuff_role on stuff.stu_num=stuff_role.sid inner join stuff_roles on stuff_role.rid=stuff_roles.role_id inner join stuff_rps on stuff_roles.role_id=stuff_rps.rid inner join stuff_permissions on stuff_rps.pid=stuff_permissions.permission_id where stuff.stu_num=#{stu_num}")
    Set<String> queryPermissionsByStunum(String stu_num);
}
