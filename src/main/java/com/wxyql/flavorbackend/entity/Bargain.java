package com.wxyql.flavorbackend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 交易信息
 * @author yql
 */

@Data
@TableName("bargains")
public class Bargain {
    @TableId
    private Integer requestId;//寻味道id
    private Integer requestUser;//寻味道用户id
    private Integer respondUser;//请品鉴用户id
    private String city;//城市
    private Date successDate;//成功日期
}
