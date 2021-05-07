package com.exam.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.exam.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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


    List<Map<String,Object>> selectAllByPage(Page<Map<String, Object>> page,
                                             @Param("user_name") String userName,
                                             @Param("user_level") String userLevel);
}
