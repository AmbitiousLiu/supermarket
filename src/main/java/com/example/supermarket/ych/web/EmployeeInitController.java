package com.example.supermarket.ych.web;

import com.alibaba.fastjson.JSONObject;
import com.example.supermarket.ych.domain.Employee;
import com.example.supermarket.ych.service.EmployeeInitService;
import com.example.supermarket.zbl.web.GetcnumController;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/Info_employee")
public class EmployeeInitController {
    @Autowired
    EmployeeInitService employeeInitService;
    private static Logger logger = Logger.getLogger(GetcnumController.class);
    LoggingEvent loggingEvent;
    @RequestMapping (value = "/getAllRegion") void selectRegion(HttpServletResponse response)throws IOException {
        String content = employeeInitService.getAllRegion();
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(content==null ?"":content);
    }
//查询雇员表信息
    @RequestMapping (value = "/getAllInfo") String initEmployee(HttpServletResponse response, HttpSession session
     , @RequestParam(value = "limit", required = true) String size,
                                                                @RequestParam(value = "page", required = true) String page)throws IOException {
        List<Employee> list = employeeInitService.queryInfo(Integer.parseInt(page),Integer.parseInt(size));
        //生成入库日期
        long time = System.currentTimeMillis();
        Date qdate = new Date(time);
        employeeInitService.insertData(session.getAttribute("stu_num").toString(),"员工管理",qdate);
        logger.info("name:" + session.getAttribute("name".toString()));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0 );
        jsonObject.put("msg","");
        jsonObject.put("count",employeeInitService.queryCounts());
        jsonObject.put("data",list);

        response.setContentType("text/json;charset=utf-8");
        return jsonObject.toString();
    }

    @RequestMapping (value = "/insertInfo") void insertEmployee(HttpServletResponse response,@RequestParam(value = "stu_num", required = true) String stu_num,
                                                                @RequestParam(value = "age", required = true) String age,
                                                                @RequestParam(value = "name", required = true) String name,
                                                                @RequestParam(value = "seniority", required = true) String seniority,
                                                                @RequestParam(value = "sex", required = true) String sex,
                                                                @RequestParam(value = "salary", required = true) String salary,
                                                                @RequestParam(value = "region", required = true) String region
                                                                )throws IOException{
        Integer integer = employeeInitService.insertInfo(region,stu_num,name,sex,seniority,Integer.parseInt(salary),Integer.parseInt(age));
//      Employee employee = new Employee(region,stu_num,name,Integer.parseInt(age),Integer.parseInt(salary),seniority,sex);
        HttpSession session = null;
        logger.info("name:" + session.getAttribute("name".toString()));
        response.setContentType("text/json;charset=utf-8");
        if (integer == 0){
            logger.error("Insert employee false!");
        } else {
            logger.info("Insert employee success!");
        }
        response.getWriter().write(integer == 0 ?"0":"1");
    }

    @RequestMapping (value = "/deleteInfo") void deleteEmployee(HttpServletResponse response, HttpServletRequest request)throws IOException{
        HttpSession session = null;
        logger.info("name:" + session.getAttribute("name".toString()));
        Integer integer = employeeInitService.deleteInfo(request.getParameter("stu_num"));
        response.setContentType("text/json;charset=utf-8");
        if (integer == 0){
            logger.error("Delete Error!");
        } else{
            logger.info("Delete success!");
        }
        response.getWriter().write(integer == 0 ?"0":"1");
    }
}
