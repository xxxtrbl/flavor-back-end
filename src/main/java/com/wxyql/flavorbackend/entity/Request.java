package com.wxyql.flavorbackend.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("requests")
public class Request {
    @TableId(value = "requestId", type = IdType.ASSIGN_UUID)
    private String requestId;

    @TableField("userId")
    private Integer userId;

    //-- 0家乡小吃/1地方特色小馆/2香辣味/3甜酸味/4绝一位菜
    @TableField("flavorType")
    private Integer flavorType;

    @TableField("city")
    private String city;

    @TableField("theme")
    private String theme;

    @TableField("intro")
    private String intro;

    @TableField("maxPrice")
    private Integer maxPrice;

    @TableField("endDate")
    private Date endDate;

    @TableField("photo")
    private String photo;

    @TableField(value = "createTime",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "reviseTime", fill = FieldFill.INSERT_UPDATE)
    private Date reviseTime;

    @TableField("curStatus")
    //-- 0:已完成 1:待响应 2:已取消 3:到期未达成
    private Integer status;
}
