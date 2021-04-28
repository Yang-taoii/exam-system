package com.exam.service;

import com.exam.entity.TUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/provider/getAll")
    List<Map<String, Object>> getAll();

    @RequestMapping("/provider/user/login")
    TUser login(@RequestParam("userName") String userName,@RequestParam("password")String password);


    @RequestMapping("/provider/user/testSession")
    String testSession();
}
