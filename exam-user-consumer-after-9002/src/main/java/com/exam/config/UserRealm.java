package com.exam.config;


import com.exam.entity.TUser;
import com.exam.service.UserFeignService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;
import java.util.Map;


/**
 * 自定义的 UserRealm
 *
 * @author：杨涛
 * @create: 2021-03-18 09:52
 */
public class UserRealm extends AuthorizingRealm {


    @Resource
    private UserFeignService service;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行：授权");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("user:regist");

        //拿到当前登录的对象
        Subject subject = SecurityUtils.getSubject();
        TUser currentUser = (TUser) subject.getPrincipal();
        if (currentUser.getRole()== 3){
            info.addStringPermission("exam_user:admin");
        }
        if (currentUser.getRole()==1){
            info.addStringPermission("exam_user:student");
        }
        if (currentUser.getRole()==2){
            info.addStringPermission("exam_user:teacher");
        }
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行：认证");
        //用户名 密码
        UsernamePasswordToken userToken =(UsernamePasswordToken)authenticationToken;
        Map<String, Object> user = service.byName(userToken.getUsername());
        if (user==null){
            return null;
        }
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        session.setAttribute("loginUser",user);
        return new SimpleAuthenticationInfo(user,user.get("password"),"");//Object principal, Object credentials, String realmName
    }
}
