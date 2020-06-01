package com.example.supermarket.ws.service;

import com.example.supermarket.ws.mapper.PermissionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class PermissionServicelmpl {
    @Resource
    PermissionMapper permissionMapper;

    public Set<String> queryPermissionsByStunum(String stu_num)
    {
        return permissionMapper.queryPermissionsByStunum(stu_num);
    }

}
