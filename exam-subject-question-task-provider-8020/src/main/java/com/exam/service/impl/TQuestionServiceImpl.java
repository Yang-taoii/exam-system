package com.exam.service.impl;

import com.exam.entity.TQuestion;
import com.exam.mapper.TQuestionMapper;
import com.exam.service.TQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 题目表 服务实现类
 * </p>
 *
 * @author yangtao
 * @since 2021-04-28
 */
@Service
public class TQuestionServiceImpl extends ServiceImpl<TQuestionMapper, TQuestion> implements TQuestionService {

}
