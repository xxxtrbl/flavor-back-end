package com.wxyql.flavorbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wxyql.flavorbackend.beans.RequestsInfo;
import com.wxyql.flavorbackend.entity.Request;

import java.util.List;

public interface IRequestService extends IService<Request> {

    /**
     * <p>添加寻味道请求</p>
     *
     * @return 添加成功 1, 否则0
     */
    int AddRequest(Request request);

    /**
     * <p>根据寻味道请求的id获取对应的请求</p>
     *
     * @return 寻味道请求条目
     */
    Request GetRequestById(Integer requestId);

    /**
     * <p>根据用户id获取其发布的所有寻味道请求</p>
     *
     * @return 所有寻味道请求条目
     */
    RequestsInfo GetRequestsByUserId(Integer userId);

    /**
     * <p>获取对应城市的所有寻味道请求</p>
     *
     * @return 对应城市的所有寻味道请求
     */
    RequestsInfo GetRequestsByCity(String city);

    /**
     * <p>获取所有寻味道请求(寻味道查询页面)</p>
     *
     * @return 所有寻味道请求
     */
    RequestsInfo GetAllRequests();

    /**
     * <p>模糊搜索(主题名称)寻味道请求</p>
     *
     * @return 所有寻味道请求
     */
    RequestsInfo FuzzySearchRequests(String keyword);

    /**
     * <p>过滤寻味道请求</p>
     * 0家乡小吃/1地方特色小馆/2香辣味/3甜酸味/4绝一位菜
     * @return 所有寻味道请求
     */
    RequestsInfo FilterRequestsByType(Integer type);

    /**
     * <p>修改未响应的请求(前端会阻止响应过的请求被修改)</p>
     *
     * @return 修改成功1, 否则0
     */
    int ReviseRequest(Request request);

    /**
     * <p>删除未响应的请求(前端会阻止响应过的请求被修改)</p>
     *
     * @return 修改成功1, 否则0
     */
    int DeleteRequest(Integer requestId);

    /**
     * <p>修改寻味道请求的状态</p>
     *
     * @return 修改成功1, 否则0
     */
    int ReviseStatus(Integer requestId, int status);

}
