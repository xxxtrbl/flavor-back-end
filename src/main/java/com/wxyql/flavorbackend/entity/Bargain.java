package com.wxyql.flavorbackend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
    @TableId(value = "requestId",type = IdType.ASSIGN_UUID)
    private Integer requestId;//寻味道id

    @TableField("requestUser")
    private Integer requestUser;//寻味道用户id

    @TableField("respondUser")
    private Integer respondUser;//请品鉴用户id

    @TableField("city")
    private String city;//城市

    @TableField("successDate")
    private Date successDate;//成功日期
}
