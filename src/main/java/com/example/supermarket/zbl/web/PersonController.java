package com.example.supermarket.zbl.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


@Controller
@RequestMapping("person")
public class PersonController {
    @RequestMapping("change")
    public String change()
    {
        return "../static/zbl/person_change";
    }
    @RequestMapping("person")
    public String person()
    {
        return "../static/zbl/person";
    }
}
