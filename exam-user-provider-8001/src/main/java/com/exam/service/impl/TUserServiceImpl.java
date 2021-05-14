package com.exam.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.TUser;
import com.exam.mapper.TUserMapper;
import com.exam.service.TUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
    public Page<Map<String, Object>> selectAllByPage(Page<Map<String, Object>> page, String userName, String userLevel) {
        return userMapper.selectAllByPage(page,userName,userLevel);
    }

    @Override
    public Boolean deleteUserById(String id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public Boolean batchDeletionById(String[] id) {
        return userMapper.batchDeletionById(id);
    }

    @Override
    public Boolean updateStatus(String id, Integer status) {
        return userMapper.updateStatus(id,status);
    }

    @Override
    public Boolean editUserInfoById(String id, String user_name, String real_name, Integer age, Integer sex, String phone, Integer role) {
        Date modify_time = new Date();
        return userMapper.editUserInfoById(id, user_name, real_name, age, sex, phone, role, modify_time);
    }

    @Override
    public Boolean saveUser(String user_name, String real_name, Integer age, Integer sex, String phone, Integer role,String password, Integer user_level, Date birth_day) {
        String user_uuid = UUID.randomUUID().toString().replace("-","");
        return userMapper.saveUser(user_name, real_name, age, sex, phone, role, user_uuid, password, user_level, birth_day);
    }

    @Override
    public Boolean updatePasswordByName(String user_name, String password) {
        return userMapper.updatePasswordByName(user_name, password);
    }
}
