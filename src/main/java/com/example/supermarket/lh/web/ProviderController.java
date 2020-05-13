package com.example.supermarket.lh.web;

import com.example.supermarket.lh.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void initCommodity(HttpServletResponse response) throws IOException {
        String content;
        content = providerService.getAllProviders();
        response.setContentType("text/json;charset=utf-8");
        if (content.equals("null")) {
            response.getWriter().write("");
        } else {
            response.getWriter().write(content);
        }
    }
}
