package com.wxyql.flavorbackend.service.implement;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxyql.flavorbackend.beans.RequestsInfo;
import com.wxyql.flavorbackend.entity.Request;
import com.wxyql.flavorbackend.mapper.IRequestMapper;
import com.wxyql.flavorbackend.service.IRequestService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

/**
 * 寻味道管理
 * @author yql
 */

@Service
public class RequestService extends ServiceImpl<IRequestMapper, Request> implements IRequestService {
    @Override
    public int addRequest(Request request) {
        this.save(request);
        return 1;
    }

    @Override
    public String picsRequest(MultipartFile multipartFile){
        String filePath = "E:/Web/FlavorBackEnd/src/main/resources/static/pic/"+multipartFile.getOriginalFilename();
        File file = new File(filePath);
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch(IOException e){
                e.printStackTrace();
            }
        }

        try{
            multipartFile.transferTo(file);
        }catch (IOException e){
            e.printStackTrace();;
        }
        return file.getAbsolutePath();
    }

    @Override
    public Request getRequestById(String requestId) {
        Request result = getById(requestId);
        return result;
    }

    @Override
    public RequestsInfo getRequestsByUserId(Integer userId) {
        QueryWrapper<Request>wrapper = new QueryWrapper<>();
        wrapper.eq("userId", userId);

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
    public int deleteRequest(String requestId) {
        removeById(requestId);
        return 1;
    }

    @Override
    public int reviseStatus(Integer requestId, int status) {
        UpdateWrapper<Request>wrapper = new UpdateWrapper<>();
        wrapper.eq("requestId", requestId)
                .set("status", status);

        update(wrapper);

        return 1;
    }
}
