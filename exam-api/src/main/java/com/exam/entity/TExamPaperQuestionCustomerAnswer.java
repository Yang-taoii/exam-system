package com.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
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
public class TExamPaperQuestionCustomerAnswer implements Serializable {

      private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 题目Id
     */
      private Integer questionId;

      /**
     * 答案Id
     */
      private Integer examPaperId;

      private Integer examPaperAnswerId;

      /**
     * 题型
     */
      private Integer questionType;

      /**
     * 学科
     */
      private Integer subjectId;

      /**
     * 得分
     */
      private Integer customerScore;

      /**
     * 题目原始分数
     */
      private Integer questionScore;

      /**
     * 问题内容
     */
      private Integer questionTextContentId;

      /**
     * 做题答案
     */
      private String answer;

      /**
     * 做题内容
     */
      private Integer textContentId;

      /**
     * 是否正确
     */
      private Boolean doRight;

      /**
     * 做题人
     */
      private Integer createUser;

      private LocalDateTime createTime;

      private Integer itemOrder;


}
