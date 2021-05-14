package com.exam.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.TUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
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
    Page<Map<String,Object>> selectAllByPage(Page<Map<String, Object>> page,
                                             @Param("user_name") String userName,
                                             @Param("user_level") String userLevel);

    Boolean deleteUserById(@Param("id")String id);

    /**
     * 批量删除
     * @param id id[]
     * @return Boolean
     */
    Boolean batchDeletionById(String[] id);

    /**
     * 通过id修改用户状态
     * @param id id
     * @param status 用户状态
     * @return Boolean
     */
    Boolean updateStatus(@Param("id")String id,@Param("status") Integer status);

    Boolean editUserInfoById(@Param("id")String id,
                             @Param("user_name")String user_name,
                             @Param("real_name")String real_name,
                             @Param("age")Integer age,
                             @Param("sex")Integer sex,
                             @Param("phone")String phone,
                             @Param("role")Integer role);

    Boolean saveUser(@Param("user_name")String user_name,
                     @Param("real_name")String real_name,
                     @Param("age")Integer age,
                     @Param("sex")Integer sex,
                     @Param("phone")String phone,
                     @Param("role")Integer role,
                     @Param("password")String password,
                     @Param("user_level") Integer user_level,
                     @Param("birth_day") Date birth_day);



    /**
     * 前端方法 忘记密码
     * @param user_name 用户名
     * @param password 密码
     * @return Boolean
     */
    Boolean updatePasswordByName(@Param("user_name")String user_name,
                                 @Param("password")String password);
}
