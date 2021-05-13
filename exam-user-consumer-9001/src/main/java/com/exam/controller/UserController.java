package com.exam.controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.TUser;
import com.exam.enums.RoleEnum;
import com.exam.service.UserFeignService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author：杨涛
 * @create: 2021-04-26 12:19
 */
@Controller
@Slf4j
public class UserController {

    @Resource
    UserFeignService service;

    @RequestMapping("/consumer/user/getAll")
    public List<Map<String, Object>> getAll(){
        return service.getAll();
    }

    /**
     * 进入登录页
     * @return login.html
     */
    @RequestMapping({"consumer/user/toUserLogin","/"})
    public String toLogin(){
        return "login";
    }
    /**
     * 进入首页
     * @return index.html
     */
    @RequestMapping("/consumer/user/toIndex")
    public String toIndex(){
        return "index";
    }
    /**
     * 进入用户信息详情页
     * @return user-info.html
     */
    @RequestMapping("/consumer/user/toUserInfo")
    public String toUserInfo(){
        return "user-info";
    }
    /**
     * 进入用户日志详情页
     * @return user-info.html
     */
    @RequestMapping("/consumer/user/toUserLog")
    public String toUserLog(){
        return "user-log";
    }
    /**
     * 进入用户add页
     * @return user-add.html
     */
    @RequestMapping("/consumer/user/toUserAdd")
    public String toUserAdd(){
        return "user-add";
    }
    /**
     * 进入用户edit页
     * @return user-edit.html
     */
    @RequestMapping("/consumer/user/toUserEdit")
    public String toUserEdit(String id,Model model){
        model.addAttribute("id",id);
        return "user-edit";
    }

    /**
     * 进入用户密码修改页
     * @return user-password.html
     */
    @RequestMapping("/consumer/user/toUserPassword")
    public String toUserPassword(String id,Model model){
        Map<String, Object> map = service.byID(id);
        model.addAttribute("current_user",map);
        return "user-password";
    }

    /**
     * 进入用户list页,并分页展示
     * @return user-list.html
     */
    @RequestMapping("/consumer/user/user-page1")
    public String page1(Integer current,String user_name,String user_level,Model model){
        System.out.println(user_level+"--"+user_name);
        Integer size = 5;
        if (current == null){
            current  = 1;
        }
        Page<Map<String, Object>> page = service.fenye(current, size, user_name, user_level);
        model.addAttribute("users",page);
        return "user-list";
    }
/******************************************************************************************/

    /**
     * 8001 用户提供者方法 查询单个用户
     * @param userName 查询用户名称
     * @return Map<String, Object>
     */
    @ResponseBody
    @RequestMapping("/consumer/user/byName")
    public Map<String, Object> byName(String userName){
        return service.byName(userName);
    }


    /**
     * 登录
     * @param userName 用户名
     * @param password 密码
     * @param model m
     * @return 首页
     */
    @RequestMapping("/login")
    public String login(String userName, String password, Model model){
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        log.info("获取当前用户--------------------->>>>>>>>{}",subject);
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
        try{
            //执行登录的方法，如果没有异常，登陆成功
            log.info("执行登录的方法,获取当前用户token---------------->>>>>>>{}",token);
            subject.login(token);
            return "forward:/consumer/user/toIndex";
        }catch (UnknownAccountException e){
            model.addAttribute("errorMsg","用户名不存在或错误");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("errorMsg","密码错误");
            return "login";
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
        return "login";
    }

    @RequestMapping("/noauth")
    @ResponseBody
    public String unauthorized(){
        return "未经授权无法访问此页面";
    }


    /**
     * ajax 获取登录用户信息
     * @param session session
     * @return user
     */
    @RequestMapping("/consumer/user/getSession")
    @ResponseBody
    public Map<String, Object> userSession(HttpSession session){
        Map<String, Object> loginUser = (Map<String, Object>) session.getAttribute("loginUser");
        return loginUser;
    }

    /**
     * 根据id删除用户
     * @param id id
     * @return Boolean
     */
    @RequestMapping("/consumer/user/del")
    @ResponseBody
    public Boolean delUser(String id){
        return service.del(id);
    }

    /**
     * 通过id修改用户状态
     * @param id id
     * @param status 用户状态
     * @return Boolean
     */
    @RequestMapping("/consumer/user/updateStatus")
    @ResponseBody
    public Boolean updateStatus(String id,Integer status){
        return service.updateStatus(id,status);
    }


    @RequestMapping("/consumer/user/updatePassword")
    @ResponseBody
    public Boolean updatePassword(String id, String password){
        System.out.println(id+"---"+password);
        return service.updatePassword(id, password, new Date());
    }


    @PostMapping("/consumer/user/updateUserInfo")
    @ResponseBody
    public Boolean updateUserInfo(String id, String user_name, String real_name, String age, String sex, String phone, String role){
        System.out.println(id+"---"+user_name+"--"+role);
        return service.updateUserInfo(id,user_name,real_name,Integer.parseInt(age),Integer.parseInt(sex),phone,Integer.parseInt(role));
    }


    @PostMapping("/consumer/user/save")
    @ResponseBody
    public Boolean saveUser(String user_name, String real_name, Integer age, Integer sex, String phone, Integer role,String password, Integer user_level, String birth_day) throws ParseException {
        System.out.println(birth_day);
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date birth_day1 = format1.parse(birth_day);
        System.out.println(birth_day1);
        return service.saveUser(user_name, password, real_name, age, sex, birth_day1, user_level, phone, role);
    }




    @RequestMapping("/consumer/user/welcome")
    @ResponseBody
    public Map<String, Object> getWelcomeData(){

        return null;
    }


}
