package com.exam.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    /**
     * 8001 用户提供者方法 查询单个用户
     * @param userName 查询用户名称
     * @return Map<String, Object>
     */
    @RequestMapping("/provider/user/byName")
    Map<String, Object> byName(@RequestParam("userName")String userName);

    /**
     * 前端用户注册
     * @param user_name name
     * @param password password
     * @return Boolean
     */
    @PostMapping(value = "/provider/user/front/save")
    Boolean saveUser2(@RequestParam("user_name")String user_name,
                             @RequestParam("password")String password);
    /**
     * 前端  忘记密码
     * @param user_name name
     * @param password password
     * @return Boolean
     */
    @PostMapping(value = "/provider/user/front/updatePassword")
    Boolean updatePassword2(@RequestParam("user_name")String user_name,
                            @RequestParam("password")String password);

}
