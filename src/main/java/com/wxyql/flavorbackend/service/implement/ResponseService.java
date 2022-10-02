package com.wxyql.flavorbackend.service.implement;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxyql.flavorbackend.beans.ResponsesInfo;
import com.wxyql.flavorbackend.entity.Response;
import com.wxyql.flavorbackend.mapper.IResponseMapper;
import com.wxyql.flavorbackend.service.IResponseService;
import org.springframework.stereotype.Service;

/**
 * 请品鉴管理
 * @author yql
 */

@Service
public class ResponseService extends ServiceImpl<IResponseMapper, Response> implements IResponseService {
    @Override
    public int AddResponse(Response respond) {
        return 0;
    }

    @Override
    public ResponsesInfo GetResponseById(Integer userId) {
        return null;
    }

    @Override
    public ResponsesInfo GetResponseByIdAndStatus(Integer userId, Integer status) {
        return null;
    }

    @Override
    public int ReviseReponse(Response newRespond) {
        return 0;
    }

    @Override
    public int DeleteReponse(Integer id) {
        return 0;
    }

    @Override
    public int ReviseStatus(Integer id, Integer status) {
        return 0;
    }
}
