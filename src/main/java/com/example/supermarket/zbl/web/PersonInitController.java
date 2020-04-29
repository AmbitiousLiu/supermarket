package com.example.supermarket.zbl.web;

import com.example.supermarket.zbl.domain.Person;
import com.example.supermarket.zbl.service.PersonInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/Info")
public class PersonInitController {
    @Autowired PersonInitService personInitService;

    @GetMapping(value = "/getInfo") void initPerson(HttpServletResponse response, @RequestParam(value = "useId" ,required = true)String useId)throws IOException {
        String content = personInitService.getAllInfo(useId);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(content==null ?"":content);

    }

    @GetMapping(value = "/modifyInfo") void modifyPerson(HttpServletResponse response, @RequestParam(value = "person" ,required = true) Person person)throws IOException{
        Integer integer = personInitService.modifyAllInfo(person);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(integer==0 ?"修改成功！":"修改失败！");
    }

}
