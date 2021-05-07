package com.exam.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.TUser;
import com.exam.mapper.TUserMapper;
import com.exam.service.TUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangtao
 * @since 2021-04-26
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

    @Autowired
    private TUserMapper userMapper;

    @Override
    public Map<String, Object> getUserByName(String userName) {
        return userMapper.getUserByName(userName);
    }

    @Override
    public List<Map<String, Object>> selectAllByPage(Page<Map<String, Object>> page, String userName, String userLevel) {
        return userMapper.selectAllByPage(page,userName,userLevel);
    }
}
