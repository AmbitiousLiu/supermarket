package com.example.supermarket.zbl.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.supermarket.zbl.service.FootPrintsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping(value = "/fprints")
public class FootPrintsController {
    @Resource
    FootPrintsService footPrintsService;

    @RequestMapping(value = "/table")
    public String getTable(HttpSession session, HttpServletResponse response, @RequestParam(value = "page")String page,
                           @RequestParam(value = "limit")String limit) throws IOException {

        String stu_num = session.getAttribute("stu_num").toString();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0 );
        jsonObject.put("msg","");
        Integer content = footPrintsService.queryRows(stu_num);
        jsonObject.put("count",content);
        System.out.println(footPrintsService.queryPrints(stu_num,Integer.parseInt(page),Integer.parseInt(limit)));
        jsonObject.put("data",footPrintsService.queryPrints(stu_num,Integer.parseInt(page),Integer.parseInt(limit)));

        return jsonObject.toString();
    }

    //访问次数统计
    @RequestMapping(value = "/sum")
    public String getSum(HttpSession session) throws IOException{
        String stu_num = session.getAttribute("stu_num").toString();

        String jsonObject = JSON.toJSONString(footPrintsService.queryUrl(stu_num));

        return jsonObject;

    }
    @RequestMapping(value = "/date")
    public String getDate(HttpSession session) throws IOException{
        String stu_num = session.getAttribute("stu_num").toString();
        String jsonObject = JSON.toJSONString(footPrintsService.queryDate(stu_num));
        return jsonObject;
    }

}
