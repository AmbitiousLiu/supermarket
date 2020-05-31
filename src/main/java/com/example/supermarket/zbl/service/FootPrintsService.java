package com.example.supermarket.zbl.service;

import com.example.supermarket.zbl.domain.FootPrints;
import com.example.supermarket.zbl.domain.Url;
import com.example.supermarket.zbl.mapper.FootPrintsMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FootPrintsService {
    @Resource
    FootPrintsMapper footPrintsMapper;
    //查询足迹所有信息
    public List<FootPrints> queryPrints(String stu_num, Integer page, Integer limit){
        Integer begin = (page -1) * limit;
        return footPrintsMapper.queryPrints(stu_num, begin, limit);
    };
    //查询该用户的足迹信息条数
   public Integer queryRows(String stu_num){
       return  footPrintsMapper.queryRows(stu_num);
   };
    //统计用户url各访问情况
    public List<Url> queryUrl(String stu_num){
        return footPrintsMapper.queryUrl(stu_num);
    };

}
