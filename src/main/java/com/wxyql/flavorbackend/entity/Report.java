package com.wxyql.flavorbackend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("reports")
public class Report {
    @TableId
    Integer id;
    Integer year;
    Integer month;
    //-- 省-市
    String city;
    //-- 0:请品鉴 1:寻味道
    Integer responseType;
    Integer respondNum;
    Integer total_money;
}
