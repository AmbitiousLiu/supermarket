package com.example.supermarket.ws.config;

import com.example.supermarket.ws.domain.Stuff;
import com.example.supermarket.ws.service.PermissionServicelmpl;
import com.example.supermarket.ws.service.RoleServiceImpl;
import com.example.supermarket.ws.service.StuffServicelmpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.Set;

/**
 * 1.创建一个类继承AuthorizingRealm（实现Realm接口的类）
 * 2.重写doGetAuthorizationInfo和doGetAuthentication方法
 * 3.
 */
public class MyRealm extends AuthorizingRealm {

    @Resource
    StuffServicelmpl stuffServicelmpl;
    @Resource
    RoleServiceImpl roleService;
    @Resource
    PermissionServicelmpl permissionServicelmpl;
    public String getName()
    {
        return "myRealm";
    }


    //获取授权信息(将当前用户的角色权限信息查询出来）
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户的用户名
        String stu_num=(String) principalCollection.iterator().next();
        //根据用户名查询当前用户的角色列表
        System.out.println(stu_num);
        Set<String> rolename=roleService.queryRoleNameByStunum(stu_num);
        //根据用户名查询当前用户的权限列表
        Set<String> ps=permissionServicelmpl.queryPermissionsByStunum(stu_num);
        SimpleAuthorizationInfo info =new SimpleAuthorizationInfo();
        info.setRoles(rolename);
        info.setStringPermissions(ps);
        return info;
    }

    //获取认证信息
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        String stu_num=token.getUsername();
        //根据

        Stuff stuff=stuffServicelmpl.findStuffByStunum(stu_num);
        if(stuff==null)
        {
            System.out.println("没查到");
            return null;
        }
        System.out.println(stuff.getPassword());
        AuthenticationInfo info =new SimpleAuthenticationInfo(stu_num,stuff.getPassword(),getName());

        return info;
    }
}
