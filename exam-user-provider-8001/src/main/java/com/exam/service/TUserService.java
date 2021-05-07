package com.exam.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.TUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangtao
 * @since 2021-04-26
 */
public interface TUserService extends IService<TUser> {

    /**
     * 更具用户名称查询用户信息
     * @param userName 用户名称
     * @return 该用户信息
     */
    Map<String, Object> getUserByName(@Param("user_name")String userName);



    /**
     * 根据用户名称、用户级别分页查询
     * @param page page
     * @param userName 用户名称
     * @param userLevel 用户级别
     * @return  List<Map<String,Object>>
     */
    List<Map<String,Object>> selectAllByPage(Page<Map<String, Object>> page,
                                             @Param("user_name") String userName,
                                             @Param("user_level") String userLevel);
}
