package com.wxyql.flavorbackend.beans;

import lombok.Data;

@Data
public class Month {
    private int year;
    private int month;

    public Month(int year, int month) {
        this.year = year;
        this.month = month;
    }
}
