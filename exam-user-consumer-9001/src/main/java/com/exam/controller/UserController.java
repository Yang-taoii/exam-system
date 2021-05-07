package com.exam.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.exam.entity.TUser;
import com.exam.service.UserFeignService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author：杨涛
 * @create: 2021-04-26 12:19
 */
@Controller
public class UserController {

    @Resource
    UserFeignService service;

    @RequestMapping("/consumer/user/getAll")
    public List<Map<String, Object>> getAll(){
        return service.getAll();
    }

    @ResponseBody
    @RequestMapping("/consumer/user/login")
    public TUser login(String userName, String password){
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        Map<String, Object> map = new HashMap<>();
        map.put("user_name",userName);
        map.put("password",password);
        wrapper.allEq(map);
        return service.login(userName,password);
    }


    @RequestMapping("/consumer/user/toLogin")
    public String toLogin(){
        return "login";
    }



















    @RequestMapping("/consumer/user/testSession")
    public String testSession(HttpSession session, String uname, String pass){
        System.out.println("消费者8090====》sessionId:"+session.getId());
        session.setAttribute("user",uname);
        String s = service.testSession();
        System.out.println("提供者返回："+s);
        return "消费者sesssionId:"+session.getId()+"====提供者:"+s;
    }
    //解决第一次访问的sessionId不同的方法
    @RequestMapping("/consumer/user/testSession2")
    public String testSession2(HttpSession session,String uname,String pass){
        System.out.println("周转方法....................");
        return  testSession(session,uname,pass);
    }

}
