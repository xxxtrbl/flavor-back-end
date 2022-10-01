package com.wxyql.flavorbackend.beans;

import lombok.Data;

@Data
public class SearchCondition {

    private Month startMonth;

    private Month endMonth;

    private String city;
}
