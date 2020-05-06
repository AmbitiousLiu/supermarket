package com.example.supermarket.ych.web;

import com.alibaba.fastjson.JSON;
import com.example.supermarket.ych.domain.Employee;
import com.example.supermarket.ych.service.EmployeeInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/Info_employee")
public class EmployeeInitController {
    @Autowired
    EmployeeInitService employeeInitService;

    @RequestMapping (value = "/getAllRegion") void selectRegion(HttpServletResponse response)throws IOException {
        String content = employeeInitService.getAllRegion();
        response.setContentType("text/json;charset=utf-8");
        System.out.println(1);
        response.getWriter().write(content==null ?"":content);
    }

    @RequestMapping (value = "/getAllInfo") void initEmployee(HttpServletResponse response, @RequestParam(value = "region") String region)throws IOException {
        System.out.println(region);
        String content = employeeInitService.getAllInfo(region);
        response.setContentType("text/json;charset=utf-8");
        System.out.println(content);
        response.getWriter().write(content==null ?"":content);
    }

    @RequestMapping (value = "/modifyInfo") void modifyEmployee(HttpServletResponse response, @RequestBody Employee employee)throws IOException{
        Integer integer = employeeInitService.modifyAllInfo(employee.getRegion(), employee.getStu_num(), employee.getName(), employee.getWork(), employee.getSign());

        response.setContentType("text/json;charset=utf-8");

//        response.getWriter().write(integer==0 ?"操作成功！":"操作失败！");

//        System.out.println(2);

        response.getWriter().write(integer == 0 ?"1":"0");
    }
}
