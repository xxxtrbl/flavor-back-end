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
    Integer requestId;//寻味道id
    Integer requestUser;//寻味道用户id
    Integer respondUser;//请品鉴用户id
    String city;//城市
    Date success_date;//成功日期
}
