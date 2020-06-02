package com.example.supermarket.sry.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sry")
public class DealController {
    @RequestMapping("deal")
            public String deal()
    {
         return "../static/sry/deal";
    }
}
