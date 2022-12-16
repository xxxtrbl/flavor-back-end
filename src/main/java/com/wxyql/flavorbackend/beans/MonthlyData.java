package com.wxyql.flavorbackend.beans;

import lombok.Data;

@Data
public class MonthlyData {
    private Month month;
    private int money;
    private int number;
}
