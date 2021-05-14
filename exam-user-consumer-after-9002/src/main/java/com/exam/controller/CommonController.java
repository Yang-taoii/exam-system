package com.exam.controller;

import com.exam.service.UserFeignService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 页面跳转
 * @author：杨涛
 * @create: 2021-05-14 09:32
 */
@Controller
public class CommonController {

    @Resource
    UserFeignService service;

    @RequestMapping("/")
    public String toLogin(){
        return "index";
    }


    @RequestMapping("/test")
    public String test(){
        return "test";
    }
    /**
     * 登录
     * @param userName 用户名
     * @param password 密码
     * @return 首页
     */
    @RequestMapping("/login")
    @ResponseBody
    public String login(String userName, String password){
        System.out.println(userName+"---------"+password);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
        try{
            //执行登录的方法，如果没有异常，登陆成功
            subject.login(token);
            token.setRememberMe(true);
            return "true";
        }catch (UnknownAccountException e){
            return "用户名不存在或错误";
        }catch (IncorrectCredentialsException e){
            return "密码错误";
        }
    }

    /**
     * 注销
     * @return  首页
     */
    @RequestMapping("/out")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "index";
    }

    /**
     * 用户名重复性验证
     * @param userName 用户名
     * @return Boolean
     */
    @RequestMapping("/user/after/checkNameRepeat")
    @ResponseBody
    public Boolean checkNameRepeat(String userName){
        System.out.println("username："+userName);
        Map<String, Object> map = service.byName(userName);
        return map == null;
    }


    @RequestMapping("/user/after/addUser")
    @ResponseBody
    public boolean addUser(String user_name,String password){
        System.out.println(user_name+"---/user/after/addUser---"+password);
        return service.saveUser2(user_name, password);
    }

    /**
     * 忘记密码
     * @param user_name 用户名
     * @param password 密码
     * @return boolean
     */
    @RequestMapping("/user/after/updatePass")
    @ResponseBody
    public boolean updatePass(String user_name,String password){
        System.out.println(user_name+"---/user/after/addUser---"+password);
        return service.updatePassword2(user_name, password);
    }
}
