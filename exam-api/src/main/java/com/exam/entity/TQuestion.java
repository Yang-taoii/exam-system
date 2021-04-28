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
public class TQuestion implements Serializable {

     private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 1.单选题  2.多选题  3.判断题 4.填空题 5.简答题
     */
      private Integer questionType;

      /**
     * 学科
     */
      private Integer subjectId;

      /**
     * 题目总分(千分制)
     */
      private Integer score;

      /**
     * 级别
     */
      private Integer gradeLevel;

      /**
     * 题目难度
     */
      private Integer difficult;

      /**
     * 正确答案
     */
      private String correct;

      /**
     * 题目  填空、 题干、解析、答案等信息   json格式 拼装
     */
      private Integer infoTextContentId;

      /**
     * 创建人
     */
      private Integer createUser;

      /**
     * 1.正常
     */
      private Integer status;

      /**
     * 创建时间
     */
      private LocalDateTime createTime;

      private Boolean deleted;


}
