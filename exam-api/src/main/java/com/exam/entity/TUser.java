package com.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yangtao
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TUser implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId(type = IdType.AUTO)
  private String id;
  private String userUuid;
  private String userName;
  private String password;
  private String realName;
  private Integer age;
  private Integer sex;
  private Date birthDay;
  private Integer userLevel;   //年级 1-12
  private String phone;
  private Integer role;  // 角色：1.学生 2.老师 3.管理员
  private Integer status; // 状态：1.启用 2禁用
  private String imagePath; // 头像地址
  private Date createTime;
  private Date modifyTime;
  private Date lastActiveTime;//最近一次登录操作
  private Integer deleted; //是否删除 1:存在 0:已删除

}
