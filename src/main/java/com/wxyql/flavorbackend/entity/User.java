package com.wxyql.flavorbackend.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("users")
public class User {

    @TableId(value = "id")
    private Integer id;

    @TableField(value = "nickname")
    private String nickname;

    @TableField(value = "password")
    private String password;

    @TableField(value = "is_admin")
    private boolean isAdmin;

    @TableField(value = "user_name")
    private String userName;

    @TableField(value = "is_id")
    private boolean isId;

    @TableField(value = "id_num")
    private String idNum;

    @TableField(value = "phone")
    private String phoneNum;

    @TableField(value = "city")
    private String city;

    /* fill automatically when inserted */
    @TableField(fill = FieldFill.INSERT)
    private Timestamp create_time;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Timestamp revise_time;
}
