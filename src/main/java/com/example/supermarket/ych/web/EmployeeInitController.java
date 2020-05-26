package com.example.supermarket.ych.web;

import com.alibaba.fastjson.JSONObject;
import com.example.supermarket.ych.domain.Employee;
import com.example.supermarket.ych.service.EmployeeInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/Info_employee")
public class EmployeeInitController {
    @Autowired
    EmployeeInitService employeeInitService;

    @RequestMapping (value = "/getAllRegion") void selectRegion(HttpServletResponse response)throws IOException {
        String content = employeeInitService.getAllRegion();
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(content==null ?"":content);
    }
//查询雇员表信息
    @RequestMapping (value = "/getAllInfo") String initEmployee(HttpServletResponse response
     ,                                                          @RequestParam(value = "limit", required = true) String size,
                                                                @RequestParam(value = "page", required = true) String page)throws IOException {
        List<Employee> list = employeeInitService.queryInfo(Integer.parseInt(page),Integer.parseInt(size));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0 );
        jsonObject.put("msg","");
        jsonObject.put("count",employeeInitService.queryCounts());
        jsonObject.put("data",list);

        response.setContentType("text/json;charset=utf-8");
        return jsonObject.toString();
//        response.getWriter().write(content==null ?"":content);
    }

    @RequestMapping (value = "/insertInfo") void insertEmployee(HttpServletResponse response, @RequestBody Employee employee)throws IOException{
//        Integer integer = employeeInitService.insertInfo(employee.getRegion(), employee.getStu_num(), employee.getName(), employee.getWork(), employee.getSign());
        response.setContentType("text/json;charset=utf-8");
//        response.getWriter().write(integer == 0 ?"0":"1");
    }

    @RequestMapping (value = "/deleteInfo") void deleteEmployee(HttpServletResponse response, HttpServletRequest request)throws IOException{
        Integer integer = employeeInitService.deleteInfo(request.getParameter("stu_num"));
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(integer == 0 ?"0":"1");
    }
}
