package com.example.supermarket.ws.security;

import com.example.supermarket.ws.domain.Stuff;
import com.example.supermarket.ws.service.Stuffservicelmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author jleo
 * @date 2020/5/10
 */
@Component("userAuthenticationSuccessHandler")
public class UserAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    Stuffservicelmp stuffservicelmp;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws ServletException, IOException {
        super.onAuthenticationSuccess(request, response, authentication);

        HttpSession session = request.getSession();
        Stuff stuff = stuffservicelmp.findStuffByName(authentication.getName());
        session.setAttribute("stu_num", stuff.stu_num);
        session.setAttribute("name", stuff.name);
        session.setAttribute("gender", stuff.gender);
        session.setAttribute("age", stuff.age);
        session.setAttribute("seniority", stuff.seniority);
        session.setAttribute("salary", stuff.salary);
        session.setAttribute("position", stuff.position);
        session.setAttribute("region", stuff.region);
    }
}
