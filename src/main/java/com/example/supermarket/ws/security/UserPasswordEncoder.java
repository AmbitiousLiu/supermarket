package com.example.supermarket.ws.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author jleo
 * @date 2020/5/10
 */
public class UserPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
