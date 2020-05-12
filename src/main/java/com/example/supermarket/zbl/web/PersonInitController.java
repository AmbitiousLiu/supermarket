package com.example.supermarket.zbl.web;

import com.example.supermarket.ljy.domain.Commodity;
import com.example.supermarket.zbl.domain.Person;
import com.example.supermarket.zbl.service.PersonInitService;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping(value = "/Info")
public class PersonInitController {
    @Autowired PersonInitService personInitService;

    @RequestMapping(value = "/getInfo") void initPerson(HttpServletResponse response, HttpSession session)throws IOException {
        String content = personInitService.getAllInfo(session.getAttribute("stu_num").toString());
//
        response.setContentType("text/json;charset=utf-8");
//        System.out.println(1);
        response.getWriter().write(content==null ?"":content);

    }

    @RequestMapping (value = "/modifyInfo") void modifyPerson(HttpServletResponse response, @RequestBody Person person )throws IOException{


        Integer integer = personInitService.modifyAllInfo(person.getName(),person.getGender(),person.getRegion(),person.getPosition(),person.getStu_num(),person.getAge(),person.getPassword());

        response.setContentType("text/json;charset=utf-8");

        response.getWriter().write(integer == 0 ?"0":"1");
    }

}
