//package com.example.supermarket.ych.web;
//
//import com.example.supermarket.ych.domain.Employee;
//import com.example.supermarket.ych.service.EmployeeInitService;
//import com.example.supermarket.zbl.domain.Person;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class EmployeeInitController {
//    @Autowired
//    EmployeeInitService employeeInitService;
//
//    @PostMapping(value = "/getInfo") void initEmployee(HttpServletResponse response, @RequestParam(value = "region" ,required = true)String region)throws IOException {
//        String content = employeeInitService.getAllInfo(region);
//        response.setContentType("text/json;charset=utf-8");
//        response.getWriter().write(content==null ?"":content);
//
//    }
//
//    @PostMapping (value = "/modifyInfo") void modifyEmployee(HttpServletResponse response, @RequestParam(value = "employee" ,required = true) Employee employee)throws IOException{
//        Integer integer = employeeInitService.modifyAllInfo(employee);
//        response.setContentType("text/json;charset=utf-8");
//        response.getWriter().write(integer==0 ?"操作成功！":"操作失败！");
//    }
//}
