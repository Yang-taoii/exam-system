package com.exam.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.TUser;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author：杨涛
 * @create: 2021-04-26 12:17
 * 这是一个用户相干 Feign 接口
 */
@Component
@FeignClient(value = "EXAM-USER-PROVIDER-8001")
public interface UserFeignService {

    @RequestMapping("/provider/user/getAll")
    List<Map<String, Object>> getAll();

    /**
     * 8001 用户提供者方法 查询单个用户
     * @param userName 查询用户名称
     * @return Map<String, Object>
     */
    @RequestMapping("/provider/user/byName")
    Map<String, Object> byName(@RequestParam("userName")String userName);


    /**
     * 8001 用户提供者方法 分页查询
     * @param current 当前页
     * @param size 容量
     * @param userName 用户名
     * @param userLevel 年级
     * @return page
     */
    @RequestMapping("/provider/user/fenye")
    Page<Map<String, Object>> fenye(@RequestParam("current")Integer current, @RequestParam("size")Integer size, @RequestParam("userName")String userName, @RequestParam("userLevel")String userLevel);

    /**
     * 8001 用户提供者方法 根据id删除用户
     * @param id id
     * @return Boolean
     */
    @RequestMapping("/provider/user/del")
    Boolean del(@RequestParam("id")String id);

    /**
     *  8001 用户提供者方法 根据id修改用户状态
     * @param id id
     * @param status 1,2
     * @return Boolean
     */
    @RequestMapping("/provider/user/updateStatus")
    Boolean updateStatus(@RequestParam("id")String id,@RequestParam("status")Integer status);

    @RequestMapping("/provider/user/updatePassword")
    Boolean updatePassword(@RequestParam("id")String id, @RequestParam("password")String password, @RequestParam("modify_time")Date modify_time);

    @RequestMapping("/provider/user/id")
    Map<String, Object> byID(@RequestParam("id")String id);

    @PostMapping("/provider/user/updateUserInfo")
    Boolean updateUserInfo(@RequestParam("id")String id,
                           @RequestParam("user_name")String user_name,
                           @RequestParam("real_name")String real_name,
                           @RequestParam("age")Integer age,
                           @RequestParam("sex")Integer sex,
                           @RequestParam("phone")String phone,
                           @RequestParam("role")Integer role);


    @PostMapping("/provider/user/save")
    Boolean saveUser(@RequestParam("user_name")String user_name,
                     @RequestParam("password")String password,
                     @RequestParam("real_name")String real_name,
                     @RequestParam("age")Integer age,
                     @RequestParam("sex")Integer sex,
                     @RequestParam("birth_day")Date birth_day,
                     @RequestParam("user_level")Integer user_level,
                     @RequestParam("phone")String phone,
                     @RequestParam("role")Integer role);

}
