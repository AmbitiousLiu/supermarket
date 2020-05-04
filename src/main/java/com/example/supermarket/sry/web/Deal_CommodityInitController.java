package com.example.supermarket.sry.web;
import com.example.supermarket.sry.service.Deal_CommodityInitService;
import com.example.supermarket.sry.service.Deal_StuffInitService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/deal")
class Deal_CommodityInitController {

    @Autowired public Deal_CommodityInitService dealCommodityInitService;
    @Autowired public Deal_StuffInitService dealStuffInitService;

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
     * GET:/deal/Commodity
     * @param cnum: it's not required
     * @param sort: it's not required
     * @param response: json string if commodities's data
     * @return
     */
    @GetMapping(value = "/commodityByCnum")
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

    /**
     * @param cnum: it is required
     * @param name: it is not required
     * @param sort: it is not required
     * @param p_date: it is not required
     * @param safe_date: it is not required
     * @param price: it is not required
     * @param sale_count: it is not required
     * @param response: json string if commodities's data
     */
    @PutMapping("/update")
    public void updateCommodityByCnum(@RequestParam(value = "cnum", required = true) String cnum,
                                      @RequestParam(value = "name", required = false) String sort,
                                        @RequestParam(value = "sort", required = false) String name,
                                      @RequestParam(value = "p_date", required = false) Date p_date,
                                      @RequestParam(value = "safe_date", required = false) Date safe_date,
                                      @RequestParam(value = "price", required = false) Integer price,
                                      @RequestParam(value = "sale_count", required = false) Integer sale_count,
                                      HttpServletResponse response) throws IOException{
        String content;
        if (cnum != null) {
            content = dealCommodityInitService.updateCommodityByCnum(cnum, sort, name, p_date, safe_date, price, sale_count);
        } else {
            content = "";
        }
        response.setContentType("text/json;charset=utf-8");
        if (content == null) {
            response.getWriter().write("");
        } else {
            response.getWriter().write(content);
        }
    }

    @GetMapping("/initPerson")
    public void initPerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (session == null) {
            return;
        }
        Object position = session.getAttribute("position");
        /*if (position == null) {
            return;
        }*/
        response.setContentType("text/json;charset=utf-8");
        System.out.println(session.getAttribute("stu_num").toString());
        response.getWriter().write(dealStuffInitService.getStufvesByStu_num(session.getAttribute("stu_num").toString()));
    }
}
