package com.wxyql.flavorbackend.service.implement;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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
    public int addResponse(Response respond) {
        save(respond);
        return 1;
    }

    @Override
    public ResponsesInfo getResponseById(Integer userId) {
        QueryWrapper<Response> wrapper = new QueryWrapper<>();

        wrapper.eq("userId", userId);

        ResponsesInfo result = new ResponsesInfo();
        result.setResponses(list(wrapper));
        return result;
    }

    @Override
    public ResponsesInfo getResponseByIdAndStatus(Integer userId, Integer status) {
        QueryWrapper<Response> wrapper = new QueryWrapper<>();

        wrapper.eq("userId", userId)
                .eq("status", status);

        ResponsesInfo result = new ResponsesInfo();
        result.setResponses(list(wrapper));
        return result;
    }

    @Override
    public int reviseResponse(Response newRespond) {
        updateById(newRespond);
        return 0;
    }

    @Override
    public int deleteReponse(Integer id) {
        removeById(id);
        return 0;
    }

    @Override
    public int reviseStatus(Integer id, Integer status) {
        UpdateWrapper<Response> wrapper = new UpdateWrapper<>();

        wrapper.eq("id", id)
                .set("status", status);

        update(wrapper);

        return 1;
    }
}
