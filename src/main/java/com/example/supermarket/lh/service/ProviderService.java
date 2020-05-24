package com.example.supermarket.lh.service;

import com.alibaba.fastjson.JSON;
import com.example.supermarket.lh.domain.Provider;
import com.example.supermarket.lh.mapper.ProviderMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProviderService {

    @Resource
    public ProviderMapper providerMapper;

    public String getAllProviders() {
        return JSON.toJSONString(providerMapper.getAllProviders());
    }
    public String addProvider(String pnum, String pname, String padd, String ptel, String pmail, String trust, String cnum, String cname){
        return JSON.toJSONString(providerMapper.addProvider(pnum,pname,padd,ptel,pmail,trust,cnum,cname));
    }
    //根据商家号查询信息
    public String getProvidersByPnum(String pnum){
        return JSON.toJSONString(providerMapper.getProvidersByPnum(pnum));
    };
}
