package com.wxyql.flavorbackend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("requests")
public class Request {
    @TableId
    private Integer requestId;
    private Integer userId;
    //-- 0家乡小吃/1地方特色小馆/2香辣味/3甜酸味/4绝一位菜
    private Integer flavorType;
    private String city;
    private String theme;
    private String intro;
    private Integer maxPrice;
    private Date endDate;
    private String photo;
    private Date createTime;
    private Date reviseTime;
    //-- 0:已完成 1:待响应 2:已取消 3:到期未达成
    private Integer status;
}
