package com.exam.mapper;

import com.exam.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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

}
