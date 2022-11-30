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

    @TableField("is_admin")
    private boolean isAdmin;

    @TableField("user_name")
    private String userName;

    @TableField("is_id")
    private boolean isId;

    @TableField("id_num")
    private String idNum;

    @TableField("phone")
    private String phoneNum;

    @TableField("city")
    private String city;

    @TableField("intro")
    private String intro;

    /* fill automatically when inserted */
    @TableField(fill = FieldFill.INSERT)
    private Date create_time;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date revise_time;
}
