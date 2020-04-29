package com.example.supermarket.zbl.web;

import com.example.supermarket.zbl.domain.Person;
import com.example.supermarket.zbl.service.PersonInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/Info")
public class PersonInitController {
    @Autowired PersonInitService personInitService;

    @RequestMapping(value = "/getInfo") void initPerson(HttpServletResponse response)throws IOException {
        String content = personInitService.getAllInfo("2");
        response.setContentType("text/json;charset=utf-8");
        System.out.println(1);
        response.getWriter().write(content==null ?"":content);

    }

    @RequestMapping (value = "/modifyInfo") void modifyPerson(HttpServletResponse response, @RequestParam(value = "person" ,required = true) Person person)throws IOException{
        Integer integer = personInitService.modifyAllInfo(person);
        response.setContentType("text/json;charset=utf-8");
        System.out.println(2);
        response.getWriter().write(integer == 0 ?"1":"0");
    }

}
