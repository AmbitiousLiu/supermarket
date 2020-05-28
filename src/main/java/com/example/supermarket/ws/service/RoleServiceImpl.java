package com.example.supermarket.ws.service;

import com.example.supermarket.ws.mapper.RoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class RoleServiceImpl {
    @Resource
    RoleMapper roleMapper;
    public Set<String> queryRoleNameByStunum(String stu_num)
    {

        return roleMapper.queryRoleNameByStunum(stu_num);
    }
}
