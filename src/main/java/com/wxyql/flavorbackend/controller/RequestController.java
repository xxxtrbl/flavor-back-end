package com.wxyql.flavorbackend.controller;

import com.wxyql.flavorbackend.beans.ReportsInfo;
import com.wxyql.flavorbackend.beans.RequestsInfo;
import com.wxyql.flavorbackend.entity.Request;
import com.wxyql.flavorbackend.service.IBargainService;
import com.wxyql.flavorbackend.service.IRequestService;
import com.wxyql.flavorbackend.service.IStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

/**
 * 寻味道相关请求响应
 * @author wxy, yql
 */

@RestController
@CrossOrigin
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
    public ResponseEntity<Object> addRequest(@RequestBody Request request){
        try {
            int result = requestService.addRequest(request);
            if(result == 1){
                return new ResponseEntity<>(null, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(null, HttpStatus.CREATED);
            }
        }catch (Exception e){
            HashMap<String, Object> response = new HashMap<>();
            response.put("msg", "服务器错误");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/uploadPics")
    public ResponseEntity<Object> uploadPics(@RequestParam("file")MultipartFile multipartFile){
        String fileUrl = requestService.picsRequest(multipartFile).replaceAll("\\\\", "/");
        return new  ResponseEntity<>(null, HttpStatus.OK);
    }

    /**
     * 根据用户id获取其所有的寻味道请求
     * @param id 用户id
     * @return 户id对应的其所有的寻味道请求
     */
    @GetMapping("/getMyRequests")
    public ResponseEntity<Object> getAllRequestsById(@RequestParam("id") Integer id){
        try {
            RequestsInfo result = requestService.getRequestsByUserId(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            HashMap<String, Object> response = new HashMap<>();
            response.put("msg", "服务器错误");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /**
     * 根据请求id获取其对应的寻味道请求
     * @param requestId 请求id
     * @return 请求id对应的其寻味道请求
     */
    @GetMapping("/searchByRequestId")
    public ResponseEntity<Object> getRequestByRequestId(@RequestParam("requestId") String requestId){
        try{
            Request result = requestService.getRequestById(requestId);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch(Exception e){
            HashMap<String,Object> response = new HashMap<>();
            response.put("msg","服务器错误");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 获取所有寻味道的请求
     * @return 所有寻味道请求
     */
    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllRequests(){
        try {
            RequestsInfo result = requestService.getAllRequests();
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            HashMap<String, Object> response = new HashMap<>();
            response.put("msg", "服务器错误");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 模糊查询请求结果
     * @param keyword 查询关键字
     * @return 请求结果
     */
    @GetMapping("/fuzzySearch")
    public ResponseEntity<Object> getRequestsSearchBy(@RequestParam("keyword") String keyword){
        try {
            RequestsInfo result = requestService.fuzzySearchRequests(keyword);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            HashMap<String, Object> response = new HashMap<>();
            response.put("msg", "服务器错误");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 获取所有分类结果
     * @param type 分类
     * @return 分类结果
     */
    @GetMapping("/filterByType")
    public ResponseEntity<Object> getRequestsByType(@RequestParam("type") Integer type){
        try {
            RequestsInfo result = requestService.filterRequestsByType(type);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            HashMap<String, Object> response = new HashMap<>();
            response.put("msg", "服务器错误");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/filterByCity")
    public ResponseEntity<Object> getRequestsByCity(@RequestParam("city") String city){
        try {
            RequestsInfo result = requestService.getRequestsByCity(city);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            HashMap<String, Object> response = new HashMap<>();
            response.put("msg", "服务器错误");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 修改未响应的寻味道请求(前端自动组织修改响应过的请求,后同)
     * @param request 寻味道请求
     * @return
     */
    @PostMapping("/revise")
    public ResponseEntity<Object> ReviseRequest(@RequestBody Request request){
        try {
            int result = requestService.reviseRequest(request);
            if (result == 1){
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(result, HttpStatus.CREATED);
            }

        }catch (Exception e){
            HashMap<String, Object> response = new HashMap<>();
            response.put("msg", "服务器错误");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/delete")
    public ResponseEntity<Object> DeleteRequest(@RequestParam("id") String id){
        try {
            int result = requestService.deleteRequest(id);
            if (result == 1){
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(result, HttpStatus.CREATED);
            }

        }catch (Exception e){
            HashMap<String, Object> response = new HashMap<>();
            response.put("msg", "服务器错误");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
