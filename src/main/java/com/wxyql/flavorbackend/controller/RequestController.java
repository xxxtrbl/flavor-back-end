package com.wxyql.flavorbackend.controller;

import com.wxyql.flavorbackend.entity.Request;
import com.wxyql.flavorbackend.service.IBargainService;
import com.wxyql.flavorbackend.service.IRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 寻味道相关请求响应
 * @author yql
 */

@RestController
@Controller
@RequestMapping("/request")
public class RequestController {

    public final IBargainService bargainService;
    public final IRequestService requestService;

    @Autowired
    public RequestController(IBargainService bargainService, IRequestService requestService){
        this.bargainService = bargainService;
        this.requestService = requestService;
    }

    @PostMapping("/addRequest")
    public ResponseEntity<Object> AddRequest(@RequestBody Request request){
        return null;
    }

    /**
     * 根据用户id获取其所有的寻味道请求
     * @param id 用户id
     * @return 户id对应的其所有的寻味道请求
     */
    @GetMapping("/getMyRequests")
    public ResponseEntity<Object> GetAllRequestsById(@RequestParam("id") Integer id){
        return null;
    }

    /**
     * 获取所有寻味道的请求
     * @return 所有寻味道请求
     */
    @GetMapping("/getAll")
    public ResponseEntity<Object> GetAllRequests(){
        return null;
    }

    /**
     * 模糊查询请求结果
     * @param keyword 查询关键字
     * @return 请求结果
     */
    @GetMapping("/fuzzySearch")
    public ResponseEntity<Object> GetRequestsSearchBy(@RequestParam("keyword") String keyword){
        return null;
    }

    /**
     * 获取所有分类结果
     * @param type 分类
     * @return 分类结果
     */
    @GetMapping("/filterByType")
    public ResponseEntity<Object> GetRequestsByType(@RequestParam("type") Integer type){
        return null;
    }

    @GetMapping("/filterByCity")
    public ResponseEntity<Object> GetRequestsByCity(@RequestParam("city") String city){
        return null;
    }

    /**
     * 修改未响应的寻味道请求(前端自动组织修改响应过的请求,后同)
     * @param request 寻味道请求
     * @return
     */
    @PostMapping("/revise")
    public ResponseEntity<Object> ReviseRequest(@RequestBody Request request){
        return null;
    }

    @GetMapping("/delete")
    public ResponseEntity<Object> DeleteRequest(@RequestParam("id") Integer id){
        return null;
    }

}
