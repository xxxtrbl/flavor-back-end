package com.wxyql.flavorbackend.beans;

import lombok.Data;

@Data
public class MonthlyMoney {

    private Month month;

    private Integer money;
}
