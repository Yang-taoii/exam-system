package com.exam.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.TUser;
import com.exam.service.TUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangtao
 * @since 2021-04-26
 */
@RestController
public class TUserController {

    @Resource
    private TUserService userService;

    @RequestMapping("/provider/user/getAll")
    public List<Map<String, Object>> getAll(){
        return userService.listMaps(new QueryWrapper<>());
    }


    /**
     * 8001 用户提供者方法 查询单个用户
     * @param userName 查询用户名称
     * @return Map<String, Object>
     */
    @RequestMapping("/provider/user/byName")
    public Map<String, Object> byName(String userName){
        return userService.getUserByName(userName);
    }

    /**
     * 8001 用户提供者方法 查询单个用户
     * @param id 查询用户id
     * @return Map<String, Object>
     */
    @RequestMapping("/provider/user/id")
    public Map<String, Object> byID(String id){
        TUser byId = userService.getById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("userName",byId.getUserName());
        map.put("password",byId.getPassword());
        map.put("id",byId.getId());
        return map;
    }


    @RequestMapping("/provider/user/add")
    public Boolean add(String userName,String password,String real_name,Integer age,Integer sex,String birth_day,Integer user_level,String phone,Integer role,String image_path) throws ParseException {
        TUser user = new TUser();
        user.setUserUuid(UUID.randomUUID().toString());
        user.setUserName(userName);
        user.setPassword(password);
        user.setPhone(phone);
        user.setSex(1);
        user.setAge(age);
        user.setRealName(real_name);
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        Date date = dateFormat.parse(birth_day);
        user.setBirthDay(date);
        user.setRole(1);
        return userService.save(user);
    }

    @RequestMapping("/provider/user/fenye")
    public Page<Map<String, Object>> fenye(Integer current,Integer size,String userName,String userLevel){
        Page<Map<String, Object>> page = new Page<>(current,size);
        Page<Map<String, Object>> selectAllByPage = userService.selectAllByPage(page, userName, userLevel);
        return selectAllByPage;
    }
    @RequestMapping("/provider/user/del")
    public Boolean del(String id){
        return userService.deleteUserById(id);
    }

    /**
     * 通过id修改用户状态
     * @param id id
     * @param status 状态
     * @return Boolean
     */
    @RequestMapping("/provider/user/updateStatus")
    public Boolean updateStatus(String id,Integer status){
        return userService.updateStatus(id,status);
    }

    @RequestMapping("/provider/user/updatePassword")
    public Boolean updatePassword(String id,String password,Date modify_time){
        TUser tUser = new TUser();
        tUser.setId(id);
        tUser.setModifyTime(modify_time);
        tUser.setPassword(password);
        return userService.updateById(tUser);
    }


    @PostMapping("/provider/user/updateUserInfo")
    public Boolean updateUserInfo(String id,String user_name,String real_name,Integer age,Integer sex,String phone,Integer role){
        return userService.editUserInfoById(id, user_name, real_name, age, sex, phone, role);
    }

    @PostMapping("/provider/user/save")
    public Boolean saveUser(String user_name,String password,String real_name,Integer age,Integer sex,Date birth_day,Integer user_level,String phone,Integer role){
        return userService.saveUser(user_name, real_name, age, sex, phone, role, password, user_level, birth_day);
    }

}

