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
    private Date revise_date;
    // -- 0:待接受; 1:同意; 2:拒绝; 3:取消
    private Integer status;
}
