package com.wxyql.flavorbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wxyql.flavorbackend.beans.ResponsesInfo;
import com.wxyql.flavorbackend.entity.Response;

public interface IResponseService extends IService<Response> {

    /**
     * <p>添加一个请品鉴响应</p>
     *
     * @return 添加成功 1, 否则0
     */
    int AddResponse(Response respond);

    /**
     * <p>通过用户id找到用户发布过的所有响应</p>
     *
     * @return 添加成功 1, 否则0
     */
    ResponsesInfo GetResponseById(Integer userId);

    /**
     * <p>通过用户id和响应的状态找到用户发布过的所有响应</p>
     *
     * @return 添加成功 1, 否则0
     */
    ResponsesInfo GetResponseByIdAndStatus(Integer userId, Integer status);

    /**
     * <p>修改请品鉴响应(前端会阻止响应过的请求被修改)</p>
     *
     * @return 修改成功 1, 否则0
     */
    int ReviseReponse(Response newRespond);

    /**
     * <p>删除一个请品鉴响应(前端会阻止响应过的请求被删除)</p>
     *
     * @return 删除成功 1, 否则0
     */
    int DeleteReponse(Integer id);

    /**
     * <p>修改请品鉴的状态</p>
     *
     * @return 修改成功1, 否则0
     */
    int ReviseStatus(Integer id, Integer status);
}
