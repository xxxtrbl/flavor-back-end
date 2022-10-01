package com.wxyql.flavorbackend.beans;

import com.wxyql.flavorbackend.entity.Report;
import lombok.Data;

import java.util.List;

@Data
public class ReportsInfo {
    private List<Report> reports;
}
