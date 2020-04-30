package com.example.supermarket.sry.web;
import com.example.supermarket.sry.service.Deal_CommodityInitService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/deal")
class Deal_CommodityInitController {

    @Autowired
    public Deal_CommodityInitService dealCommodityInitService;

    /**
     * GET:/deal/Commodity ('content ?: ""' means return "" if content is null)
     * @param response: json string of commodities's data
     * @return
     */
    @GetMapping(value = "/commodity")
    public void initCommodity(HttpServletResponse response) throws IOException {
        String content = dealCommodityInitService.getAllCommodities();
        response.setContentType("text/json;charset=utf-8");
        if (content == null) {
            response.getWriter().write("");
        } else {
            response.getWriter().write(content);
        }
    }

    /**
     * DELETE:/deal/delete ('content ?: ""' means return "" if content is null)
     * @param cnum: it's required
     * @return
     */
    @DeleteMapping(value = "/delete")
    public void deleteCommodityByParam(@RequestParam(value = "cnum", required = true) String cnum,HttpServletResponse response) throws IOException{
        String content;
        if(cnum != null){
            content = dealCommodityInitService.deleteCommodityByCnum(cnum);
        } else{
            content = "Have no cnum";
        }
        response.setContentType("text/json;charset=utf-8");
        if(content.length() <= 1){
            response.getWriter().write("Delete success");
        } else{
            response.getWriter().write(content);
        }
    }

    /**
     * POST:/deal/Commodity
     * @param cnum: it's not required
     * @param sort: it's not required
     * @param response: json string if commodities's data
     * @return
     */
    @PostMapping(value = "/commodity")
    public void initCommodityByParam(@RequestParam(value = "cnum", required = false) String cnum,
                                                            @RequestParam(value = "sort", required = false) String sort,
                                                            HttpServletResponse response)  throws IOException  {
        String content;
        if (cnum != null) {
            content = dealCommodityInitService.getCommodityByCnum(cnum);
        } else {
            if (sort != null) {
                content = dealCommodityInitService.getCommoditiesBySort(sort);
            } else {
                content = "";
            }
        }
        response.setContentType("text/json;charset=utf-8");
        if (content == null) {
            response.getWriter().write("");
        } else {
            response.getWriter().write(content);
        } 
    }

}
