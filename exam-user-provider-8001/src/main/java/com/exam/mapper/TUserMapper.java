package com.exam.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yangtao
 * @since 2021-04-26
 */
@Mapper
@Repository
public interface TUserMapper extends BaseMapper<TUser> {

    /**
     * 更具用户名称查询用户信息
     * @param userName 用户名称
     * @return 该用户信息
     */
    Map<String, Object> getUserByName(@Param("user_name")String userName);


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
                             @Param("role")Integer role,
                             @Param("modify_time")Date modify_time);

    Boolean saveUser(@Param("user_name")String user_name,
                     @Param("real_name")String real_name,
                     @Param("age")Integer age,
                     @Param("sex")Integer sex,
                     @Param("phone")String phone,
                     @Param("role")Integer role,
                     @Param("user_uuid")String user_uuid,
                     @Param("password")String password,
                     @Param("user_level") Integer user_level,
                     @Param("birth_day") Date birth_day);

    Boolean updatePasswordByName(@Param("user_name")String user_name,
                                 @Param("password")String password);
}
