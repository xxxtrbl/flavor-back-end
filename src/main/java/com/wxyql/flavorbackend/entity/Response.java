package com.wxyql.flavorbackend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("responses")
public class Response {
    @TableId
    private Integer id;
    private Integer requestId;
    private Integer respondUserId;
    private String respondIntro;
    private Date respondDate;
    private Date reviseDate;
    // -- 0:待接受; 1:同意; 2:拒绝; 3:取消
    private Integer status;

    public static final int STATUS_WAITING = 0;
    public static final int STATUS_ACCEPTED = 1;
    public static final int STATUS_REJECTED = 2;
    public static final int STATUS_CANCELLED = 3;
}
