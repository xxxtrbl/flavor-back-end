package com.wxyql.flavorbackend.service.implement;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxyql.flavorbackend.beans.RequestsInfo;
import com.wxyql.flavorbackend.entity.Request;
import com.wxyql.flavorbackend.mapper.IRequestMapper;
import com.wxyql.flavorbackend.service.IRequestService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 寻味道管理
 * @author yql
 */

@Service
@EnableScheduling
public class RequestService extends ServiceImpl<IRequestMapper, Request> implements IRequestService {
    @Override
    public int addRequest(Request request) {
        this.save(request);
        return 1;
    }

    @Override
    public Request getRequestById(Integer requestId) {
        Request result = getById(requestId);
        return result;
    }

    @Override
    public RequestsInfo getRequestsByUserId(Integer userId) {
        QueryWrapper<Request>wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);

        RequestsInfo result = new RequestsInfo();

        result.setRequests(list(wrapper));

        return result;
    }

    @Override
    public RequestsInfo getRequestsByCity(String city) {
        QueryWrapper<Request>wrapper = new QueryWrapper<>();
        wrapper.eq("city", city);

        RequestsInfo result = new RequestsInfo();

        result.setRequests(list(wrapper));

        return result;
    }

    @Override
    public RequestsInfo getAllRequests() {
        RequestsInfo result = new RequestsInfo();

        result.setRequests(list());

        return result;
    }

    @Override
    public RequestsInfo fuzzySearchRequests(String keyword) {
        QueryWrapper<Request> wrapper = new QueryWrapper<>();
        wrapper.like("theme", keyword);

        RequestsInfo result = new RequestsInfo();

        result.setRequests(list(wrapper));

        return result;
    }

    @Override
    public RequestsInfo filterRequestsByType(Integer type) {
        QueryWrapper<Request> wrapper = new QueryWrapper<>();
        wrapper.like("type", type);

        RequestsInfo result = new RequestsInfo();

        result.setRequests(list(wrapper));

        return result;
    }

    @Override
    public int reviseRequest(Request request) {
        saveOrUpdate(request);
        return 1;
    }

    @Override
    public int deleteRequest(Integer requestId) {
        removeById(requestId);
        return 1;
    }

    @Override
    public int reviseStatus(Integer requestId, int status) {
        UpdateWrapper<Request>wrapper = new UpdateWrapper<>();
        wrapper.eq("request_id", requestId)
                .set("status", status);

        update(wrapper);

        return 1;
    }

    @Override
    @Scheduled(cron="0 0 0 * * *")// 每日零点更新
    public int updateRequestStatusToday() {
        Date timeNow = new Date();

        UpdateWrapper<Request>wrapper = new UpdateWrapper<>();
        wrapper.le("end_date", timeNow)
                .set("status", 3);

        return 0;
    }
}
