package com.exam.service.impl;

import com.exam.entity.TUserEventLog;
import com.exam.mapper.TUserEventLogMapper;
import com.exam.service.TUserEventLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户事件日志，记录用户操作信息 服务实现类
 * </p>
 *
 * @author yangtao
 * @since 2021-04-26
 */
@Service
public class TUserEventLogServiceImpl extends ServiceImpl<TUserEventLogMapper, TUserEventLog> implements TUserEventLogService {

}
