package com.wxyql.flavorbackend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("responses")
public class Response {
    @TableId
    Integer id;
    Integer requestId;
    Integer respondUserId;
    String respondIntro;
    Date respondDate;
    Date revise_date;
    // -- 0:待接受; 1:同意; 2:拒绝; 3:取消
    Integer status;
}
