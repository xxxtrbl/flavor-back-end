package com.wxyql.flavorbackend.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;


@Data
@TableName(value = "users")
public class User {

    @TableId(value = "id")
    private Integer id;

    @TableField("nickname")
    private String nickname;

    @TableField("pwd")
    private String password;

    @TableField("isAdmin")
    private boolean isAdmin;

    @TableField("userName")
    private String userName;

    @TableField("isIdCard")
    private boolean isIdCard;

    @TableField("idNum")
    private String idNum;

    @TableField("phone")
    private String phone;

    @TableField("city")
    private String city;

    @TableField("intro")
    private String intro;

    /* fill automatically when inserted */
    @TableField(value = "createTime",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "reviseTime", fill = FieldFill.INSERT_UPDATE)
    private Date reviseTime;
}
