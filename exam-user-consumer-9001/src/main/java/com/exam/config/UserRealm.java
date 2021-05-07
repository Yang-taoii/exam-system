//package com.exam.config;
//
//
//import com.exam.entity.TUser;
//import com.exam.enums.RoleEnum;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.session.Session;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.subject.Subject;
//
//
///**
// * 自定义的 UserRealm
// *
// * @author：杨涛
// * @create: 2021-03-18 09:52
// */
//public class UserRealm extends AuthorizingRealm {
//
//    //授权
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println("执行：授权");
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.addStringPermission("user:regist");
//
//        //拿到当前登录的对象
//        Subject subject = SecurityUtils.getSubject();
//        TUser currentUser = (TUser) subject.getPrincipal();
//        if (currentUser.getRole()== 3){
//            info.addStringPermission("vote:admin");
//        }
//        return info;
//    }
//
////    //认证
////    @Override
////    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
////        System.out.println("执行：认证");
////        //用户名 密码
////        UsernamePasswordToken userToken =(UsernamePasswordToken)authenticationToken;
////        System.out.println(userToken);
////        //TUser user = voteUserService.selectUserByName(userToken.getUsername());
////        if (user==null){
////            return null;
////        }
////        Subject currentUser = SecurityUtils.getSubject();
////        Session session = currentUser.getSession();
////        session.setAttribute("loginUser",user);
////        return new SimpleAuthenticationInfo(user,user.getVuPassword(),"");//Object principal, Object credentials, String realmName
////    }
//}
