package com.exam.mapper;

import com.exam.entity.TQuestion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 题目表 Mapper 接口
 * </p>
 *
 * @author yangtao
 * @since 2021-04-28
 */
@Mapper
@Repository
public interface TQuestionMapper extends BaseMapper<TQuestion> {

}
