package com.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class TSubject implements Serializable {

      private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 语文 数学 英语 等
     */
      private String name;

      /**
     * 年级 (1-12) 小学 初中 高中  大学
     */
      private Integer level;

      /**
     * 一年级、二年级等
     */
      private String levelName;

      /**
     * 排序
     */
      private Integer itemOrder;

      private Boolean deleted;


}
