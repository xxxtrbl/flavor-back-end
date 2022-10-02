package com.wxyql.flavorbackend.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("reports")
public class Report {
    @TableId
    private Integer id;
    private Integer year;
    private Integer month;
    //-- 省-市
    private String city;
    //-- 0:请品鉴 1:寻味道
    private Integer responseType;
    private Integer respondNum;
    private Integer totalMoney;

    public static final int RESPONSE_TYPE_RESPONSE = 0;
    public static final int RESPONSE_TYPE_REQUEST = 1;

    public static final int RESPONSE_PRICE = 1;
    public static final int REQUEST_PRICE = 3;
}
