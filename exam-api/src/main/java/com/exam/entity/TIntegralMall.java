package com.exam.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TIntegralMall {
  private Integer prodId;
  private String userUuid;
  private String prodName;
  private Integer prodCount;
  private Integer prodPrice;
  private Integer prodState;
  private Date createTime;
  private Integer prodClass;


}
