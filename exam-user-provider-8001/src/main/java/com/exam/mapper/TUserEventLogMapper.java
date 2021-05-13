package com.exam.mapper;

import com.exam.entity.TUserEventLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户事件日志，记录用户操作信息 Mapper 接口
 * </p>
 *
 * @author yangtao
 * @since 2021-04-26
 */
@Mapper
@Repository
public interface TUserEventLogMapper extends BaseMapper<TUserEventLog> {

    List<Map<String,Object>> getUserLogByNameOrUUid(@Param("user_id")String uuid,@Param("user_name")String userName);
}
