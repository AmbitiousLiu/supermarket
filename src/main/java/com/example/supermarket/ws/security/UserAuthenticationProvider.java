package com.example.supermarket.ws.security;

import com.example.supermarket.ws.domain.Stuff;
import com.example.supermarket.ws.service.Stuffservicelmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author jleo
 * @date 2020/5/10
 */
@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private Stuffservicelmp stuffservicelmp;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();
        Stuff stuff = stuffservicelmp.findStuff(userName, password);
        if (stuff == null) {
            throw new BadCredentialsException("用户名或密码错误");
        }
        Collection<? extends GrantedAuthority> authorities = stuff.getAuthorities();
        return new UsernamePasswordAuthenticationToken(stuff, password, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
