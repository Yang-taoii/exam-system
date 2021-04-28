package com.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author yangtao
 * @since 2021-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TExamPaper implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

      /**
     * 试卷名称
     */
      private String name;

      /**
     * 学科
     */
      private Integer subjectId;

      /**
     * 试卷类型( 1固定试卷  2临时试卷 3班级试卷 4.时段试卷 5.推送试卷) 默认 1
     */
      private Integer paperType;

      /**
     * 年级级别
     */
      private Integer gradeLevel;

      /**
     * 试卷总分
     */
      private Integer score;

      /**
     * 题目数量
     */
      private Integer questionCount;

      /**
     * 建议时长(分钟)
     */
      private Integer suggestTime;

      /**
     * 时段试卷 开始时间
     */
      private Date limitStartTime;

      /**
     * 时段试卷 结束时间
     */
      private Date limitEndTime;

      /**
     * 试卷框架 内容为JSON
     */
      private Integer frameTextContentId;

      /**
     * 创建者的uuid
     */
      private String createUser;

      private Date createTime;

      /**
     * 是否删除 1:存在 0:已删除
     */
      private Integer deleted;

      /**
     * 试卷课题id
     */
      private Integer taskExamId;


}
