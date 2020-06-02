package com.example.supermarket.sry.web;

import com.example.supermarket.sry.domain.LogInfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Configuration
public class LogConfig {
    private Logger logger = LoggerFactory.getLogger(this.getClass());



    //扫描并拦截对应包下的controller的接口
    @Pointcut("execution(* com.example.supermarket.*.*(..))")
    public void log(){}

    //在log()方法执行之前执行doBefore()方法
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("------------before--------------");
        //拦截请求，获取请求的url、ip、方法名、参数等信息写入日志文件
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String ip = request.getRemoteAddr();
        String url = request.getRequestURL().toString();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName()+ "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        LogInfo log = new LogInfo(ip,url,classMethod,args);
        logger.info("request : {}",log);
    }

    //在log()方法执行之后执行doAfter()方法
    @After("log()")
    public void doAfter(){
        logger.info("------------after--------------");
    }
}
