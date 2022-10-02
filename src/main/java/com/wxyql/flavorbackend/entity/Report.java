package com.wxyql.flavorbackend.entity;

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
    private Integer total_money;
}
