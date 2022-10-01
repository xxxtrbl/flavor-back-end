package com.wxyql.flavorbackend.beans;

import com.wxyql.flavorbackend.entity.Response;
import lombok.Data;

import java.util.List;

@Data
public class ResponsesInfo {
    private List<Response> responses;
}
