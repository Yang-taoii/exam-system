package com.exam.service.impl;

import com.exam.entity.TUser;
import com.exam.mapper.TUserMapper;
import com.exam.service.TUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
