package com.exam.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author yangtao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TUserEventLog {

  private Long id;
  private Integer userId;
  private String userName;
  private String realName;
  private String content; //操作内容
  private Date createTime;

}
