package com.wxyql.flavorbackend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("reports")
public class Report {
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @TableField("yy")
    private Integer year;

    @TableField("mm")
    private Integer month;

    //-- 省-市
    @TableField("city")
    private String city;

    //-- 0:请品鉴 1:寻味道
    @TableField("responseType")
    private Integer responseType;

    @TableField("respondNum")
    private Integer respondNum;

    @TableField("totalMoney")
    private Integer totalMoney;

    public static final int RESPONSE_TYPE_RESPONSE = 0;
    public static final int RESPONSE_TYPE_REQUEST = 1;

    public static final int RESPONSE_PRICE = 1;
    public static final int REQUEST_PRICE = 3;
}
