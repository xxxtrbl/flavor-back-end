package com.wxyql.flavorbackend.controller;

import com.wxyql.flavorbackend.entity.Request;
import com.wxyql.flavorbackend.service.IBarginService;
import com.wxyql.flavorbackend.service.IRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@RequestMapping("/request")
public class RequestController {

    public final IBarginService barginService;
    public final IRequestService requestService;

    @Autowired
    public RequestController(IBarginService barginService,IRequestService requestService){
        this.barginService = barginService;
        this.requestService = requestService;
    }

    @PostMapping("/addRequest")
    public ResponseEntity<Object> AddRequest(@RequestBody Request request){

    }

    /**
     * 根据用户id获取其所有的寻味道请求
     * @param id
     * @return 户id对应的其所有的寻味道请求
     */
    @GetMapping("/getMyRequests")
    public ResponseEntity<Object> GetAllRequestsById(@RequestParam("id") Integer id){

    }

    /**
     * 获取所有寻味道的请求
     * @return 所有寻味道请求
     */
    @GetMapping("/getAll")
    public ResponseEntity<Object> GetAllRequests(){

    }

    /**
     * 模糊查询请求结果
     * @param keyword
     * @return 请求结果
     */
    @GetMapping("/fuzzySearch")
    public ResponseEntity<Object> GetRequestsSearchBy(@RequestParam("keyword") String keyword){

    }

    /**
     * 获取所有分类结果
     * @param type
     * @return 分类结果
     */
    @GetMapping("/filterByType")
    public ResponseEntity<Object> GetRequestsByType(@RequestParam("type") Integer type){

    }

    @GetMapping("/filterByCity")
    public ResponseEntity<Object> GetRequestsByCity(@RequestParam("city") String city){

    }

    /**
     * 修改未响应的请求(前端自动组织修改响应过的请求,后同)
     * @param request
     * @return
     */
    @PostMapping("/revise")
    public ResponseEntity<Object> ReviseRequest(@RequestBody Request request){

    }

    @GetMapping("/delete")
    public ResponseEntity<Object> DeleteRequest(@RequestParam("id") Integer id){

    }

}
