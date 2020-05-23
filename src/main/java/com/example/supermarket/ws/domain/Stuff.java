package com.example.supermarket.ws.domain;

import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

@Data
public class Stuff implements Serializable{
    public String stu_num;
    public String password;
    public String name;
    public String gender;
    public Integer age;
    public Integer seniority;
    public Integer salary;
    public String position;
    public String region;

    public Boolean accountNonExpired;
    public Boolean accountNonLocked;
    public Boolean credentialsNonExpired;
    public Boolean enabled;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return AuthorityUtils.commaSeparatedStringToAuthorityList(position);
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return stu_num;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return accountNonExpired;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return accountNonLocked;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return credentialsNonExpired;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return enabled;
//    }
}
