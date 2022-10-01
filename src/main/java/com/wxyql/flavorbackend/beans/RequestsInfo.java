package com.wxyql.flavorbackend.beans;

import com.wxyql.flavorbackend.entity.Request;
import lombok.Data;

import java.util.List;

@Data
public class RequestsInfo {
    private List<Request> requests;
}
