package com.example.supermarket.sry.web;
import com.example.supermarket.sry.Redis.Redis;
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
import org.apache.log4j.Logger;

@RestController
@RequestMapping(value = "/deal")
class Deal_CommodityInitController {

    @Autowired public Deal_CommodityInitService dealCommodityInitService;
    @Autowired public Deal_StuffInitService dealStuffInitService;
    Redis redis = new Redis();
    private static Logger logger = Logger.getLogger(Deal_CommodityInitController.class);
    /**
     * GET:/deal/Commodity ('content ?: ""' means return "" if content is null)
     * @param response: json string of commodities's data
     * @return
     */
    @GetMapping(value = "/commodity")
    public void initCommodity(HttpServletResponse response) throws IOException {
        String content;
        if(redis.exists("cnum_")){
            logger.info("Info Message, Use Redis to select value in cache");
            content = redis.get("cnum_");
        }else{
            content = dealCommodityInitService.getAllCommodities();
            redis.set("cnum_",content);
            redis.expire("cnum_", 3600);
            logger.info("Info Message, Use Mysql to select value in mysql");
        }
        response.setContentType("text/json;charset=utf-8");
        if (content == null) {
            response.getWriter().write("");
            logger.error("Error Message, No Commodities in database");
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
            redis.expire("cnum_"+cnum, 0);
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
     * @param response: json string if commodities's data
     * @return
     */
    @GetMapping(value = "/commodityByCnum")
    public void initCommodityByParam(@RequestParam(value = "cnum") String cnum,
                                                            HttpServletResponse response)  throws IOException  {
        String content;
        if(redis.exists("cnum_"+cnum)){
            content = redis.get("cnum_"+cnum);
            if(content.equals("null")){
                redis.expire("cnum_"+cnum, 0);
                content = dealCommodityInitService.getCommodityByCnum(cnum);
                redis.set("cnum_"+cnum,content);
                redis.expire("cnum_"+cnum, 3600);
                logger.info("Info Message, Update Redis to save cnum: " + cnum +" in cache");
            }
            logger.info("Info Message, Use Redis to select cnum: " + cnum +" in cache");
        }else{
            content = dealCommodityInitService.getCommodityByCnum(cnum);
            redis.set("cnum_"+cnum,content);
            redis.expire("cnum_"+cnum, 3600);
            logger.info("Info Message, Use Mysql to select cnum: " + cnum +" in Mysql");
        }
        response.setContentType("text/json;charset=utf-8");
        if (content.equals("null")) {
            response.getWriter().write("");
            logger.info("Error Message, Can't find cnum: " + cnum +" in Mysql");
        } else {
            response.getWriter().write(content);
        } 
    }

    /**
     * @param cnum: it is required
     * @param name: it is not required
     * @param price_out: it is not required
     * @param response: json string if commodities's data
     */
    @PutMapping(value = "/update")
    public void updateCommodityByCnum(@RequestParam(value = "cnum", required = false) String cnum,
                                        @RequestParam(value = "name", required = false) String name,
                                      @RequestParam(value = "price_out", required = false) Integer price_out,
                                      HttpServletResponse response) throws IOException{
        String content;
        if (cnum != null) {
            content = dealCommodityInitService.updateCommodityByCnum(cnum, name, price_out);
            redis.expire("cnum_"+cnum, 0);
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

    @GetMapping(value = "/region")
    String initRegion(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String region = (String) session.getAttribute("region");
        return region;
    }

    @GetMapping(value = "/userName")
    String initUserName(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String name = (String)session.getAttribute("name");
        return name;
    }

    @GetMapping(value = "/userPosition")
    String initUserPosition(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String position = (String) session.getAttribute("position");
        return position;
    }
}
