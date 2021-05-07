package com.exam.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.exam.entity.TUser;
import com.exam.service.TUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


}

