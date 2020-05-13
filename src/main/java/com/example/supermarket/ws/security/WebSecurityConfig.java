package com.example.supermarket.ws.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author jleo
 * @date 2020/5/9
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationProvider provider;

    @Autowired
    private UserAuthenticationSuccessHandler userAuthenticationSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/ws/login.html").permitAll()
                .loginProcessingUrl("/doLogin").permitAll()
                .failureUrl("/ws/fault.html").permitAll()
                .successHandler(userAuthenticationSuccessHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/ws/**").permitAll()
                .antMatchers("/ljy/**").hasAnyRole("副经理", "库房管理人员", "总经理")
                .antMatchers("/ych/**").hasAnyRole("总经理", "副经理")
                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws  Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("123456").roles("USER")
//                .and()
//                .passwordEncoder(new UserPasswordEncoder());
        auth.authenticationProvider(provider);
    }


}
