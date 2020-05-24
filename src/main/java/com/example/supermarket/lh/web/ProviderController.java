package com.example.supermarket.lh.web;

import com.example.supermarket.lh.domain.Provider;
import com.example.supermarket.lh.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/provider")
public class ProviderController {
    @Autowired
    ProviderService providerService;
    /**
     * GET:/deal/Commodity ('content ?: ""' means return "" if content is null)
     * @param response: json string of commodities's data
     * @return
     */
    @GetMapping(value = "/provider")
    public void getAllProviders(HttpServletResponse response) throws IOException {
        String content;
        content = providerService.getAllProviders();
        response.setContentType("text/json;charset=utf-8");
        if (content.equals("null")) {
            response.getWriter().write("");
        } else {
            response.getWriter().write(content);
        }
    }

    /**
     * POST:/commodity/deal
     * @return
     */
    @PostMapping(value = "/add")
    public void addProvider(@RequestBody Provider provider,
                            HttpServletResponse response)throws IOException{
        String content;
        content = providerService.addProvider(provider.getPnum(),provider.getPname(),provider.getPadd(),provider.getPtel(),provider.getPmail(),provider.getTrust(),provider.getCnum(),provider.getCname());
        response.setContentType("text/json;charset=utf-8");
        if (content.equals("null")) {
            response.getWriter().write("");
        } else {
            response.getWriter().write(content);
        }
    }
    @GetMapping(value = "/getInfo")
    //根据商家号查询商家信息
    public void getInfoByPnum(@RequestParam(value = "pnum")String pnum,
                              HttpServletResponse response)throws IOException{
        System.out.println(pnum);
        String content = providerService.getProvidersByPnum(pnum);
//        System.out.println(content);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(content == null? "" : content);
    }
}
