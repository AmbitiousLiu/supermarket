package com.example.supermarket.ws.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.config.Ini;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroDialect getShiroDialect()
    {
        return new ShiroDialect();
    }
    @Bean
    public HashedCredentialsMatcher getHashedCredentialsMatcher()
    {
        HashedCredentialsMatcher matcher=new HashedCredentialsMatcher();

        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(1);

        return matcher;
    }

    @Bean
    public  MyRealm getMyRealm(HashedCredentialsMatcher matcher)
    {
        MyRealm myRealm =new MyRealm();
        myRealm.setCredentialsMatcher(matcher);
        return myRealm;
    }
    @Bean
    public DefaultWebSessionManager getDefaultWebSessionManager()
    {
        DefaultWebSessionManager sessionManager =new DefaultWebSessionManager();
        return sessionManager;
    }

    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(MyRealm myRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        securityManager.setSessionManager(getDefaultWebSessionManager());
        return securityManager;
    }
    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean filter =new ShiroFilterFactoryBean();

        filter.setSecurityManager(securityManager);
        //设置shiro的拦截规则
        //anon匿名用户可访问
        //authc认证用户可访问
        //user使用RememberMe的用户看访问
        //perms[]对应权限可访问
        //
        Map<String,String> filterMap= new HashMap<>();

        filterMap.put("/","anon");
        filterMap.put("/ws/**","anon");
        filterMap.put("/ws/user/login","anon");
        filterMap.put("ws/user/login","anon");
        filterMap.put("/layui/**","anon");
        filterMap.put("/ws/login.html","logout");
        filterMap.put("/zbl/person.html","authc");




        filter.setFilterChainDefinitionMap(filterMap);
        //默认登录页面
        filter.setLoginUrl("/ws/login.html");
        //设置未授权访问的页面路径
        filter.setUnauthorizedUrl("/ws/login.html");
        return filter;
    }
}
