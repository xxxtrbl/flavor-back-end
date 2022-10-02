package com.wxyql.flavorbackend.service.implement;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxyql.flavorbackend.beans.RequestsInfo;
import com.wxyql.flavorbackend.entity.Request;
import com.wxyql.flavorbackend.mapper.IRequestMapper;
import com.wxyql.flavorbackend.service.IRequestService;
import org.springframework.stereotype.Service;

/**
 * 寻味道管理
 * @author yql
 */

@Service
public class RequestService extends ServiceImpl<IRequestMapper, Request> implements IRequestService {
    @Override
    public int AddRequest(Request request) {
        return 0;
    }

    @Override
    public Request GetRequestById(Integer requestId) {
        return null;
    }

    @Override
    public RequestsInfo GetRequestsByUserId(Integer userId) {
        return null;
    }

    @Override
    public RequestsInfo GetRequestsByCity(String city) {
        return null;
    }

    @Override
    public RequestsInfo GetAllRequests() {
        return null;
    }

    @Override
    public RequestsInfo FuzzySearchRequests(String keyword) {
        return null;
    }

    @Override
    public RequestsInfo FilterRequestsByType(Integer type) {
        return null;
    }

    @Override
    public int ReviseRequest(Request request) {
        return 0;
    }

    @Override
    public int DeleteRequest(Integer requestId) {
        return 0;
    }

    @Override
    public int ReviseStatus(Integer requestId, int status) {
        return 0;
    }
}
