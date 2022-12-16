package com.wxyql.flavorbackend.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("responses")
public class Response {
    @TableId(value="id", type = IdType.ASSIGN_UUID)
    private String id;

    @TableField("requestId")
    private String requestId;

    @TableField("respondUserId")
    private Integer respondUserId;

    @TableField("respondIntro")
    private String respondIntro;

    @TableField(value = "createTime",fill= FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "reviseTime", fill = FieldFill.INSERT_UPDATE)
    private Date reviseTime;

    @TableField("state")
    // -- 0:待接受; 1:同意; 2:拒绝; 3:取消
    private Integer status;

    public static final int STATUS_WAITING = 0;
    public static final int STATUS_ACCEPTED = 1;
    public static final int STATUS_REJECTED = 2;
    public static final int STATUS_CANCELLED = 3;
}
