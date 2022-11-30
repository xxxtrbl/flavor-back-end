package com.wxyql.flavorbackend.controller;

import com.wxyql.flavorbackend.beans.RequestsInfo;
import com.wxyql.flavorbackend.beans.ResponsesInfo;
import com.wxyql.flavorbackend.entity.Response;
import com.wxyql.flavorbackend.service.IBargainService;
import com.wxyql.flavorbackend.service.IResponseService;
import com.wxyql.flavorbackend.service.IStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * 请品鉴
 * @author wxy, yql
 */

@RestController
@Controller
@CrossOrigin
@RequestMapping("/response")
public class ResponseController {
    public final IBargainService bargainService;
    public final IResponseService responseService;
    public final IStatisticService statisticService;

    @Autowired
    public ResponseController(IBargainService bargainService, IResponseService responseService, IStatisticService statisticService){
        this.bargainService = bargainService;
        this.responseService = responseService;
        this.statisticService = statisticService;
    }


    @PostMapping("/add")
    public ResponseEntity<Object> addResponse(@RequestBody Response userResponse) {
        try {
            int result = responseService.addResponse(userResponse);
            if(result == 1){
                return new ResponseEntity<>(null, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(null, HttpStatus.CREATED);
            }
        }catch (Exception e){
            HashMap<String, Object> response = new HashMap<>();
            response.put("msg", "服务器错误");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/delete")
    public ResponseEntity<Object> deleteResponse(@RequestParam("id") Integer id){
        try {
            int result = responseService.deleteReponse(id);
            if(result == 1){
                return new ResponseEntity<>(null, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(null, HttpStatus.CREATED);
            }
        }catch (Exception e){
            HashMap<String, Object> response = new HashMap<>();
            response.put("msg", "服务器错误");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/revise")
    public ResponseEntity<Object> reviseResponse(@RequestBody Response userResponse){
        try {
            int result = responseService.reviseResponse(userResponse);
            if(result == 1){
                return new ResponseEntity<>(null, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(null, HttpStatus.CREATED);
            }
        }catch (Exception e){
            HashMap<String, Object> response = new HashMap<>();
            response.put("msg", "服务器错误");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 根据寻味道请求id获取对应的响应
     * @param id 寻味道请求id
     * @return 请求id对应的响应
     */
    @GetMapping("/getById")
    public ResponseEntity<Object> getResponseByRequestId(@RequestParam("requestId") Integer id){
        try {
            ResponsesInfo result = responseService.getResponseById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            HashMap<String, Object> response = new HashMap<>();
            response.put("msg", "服务器错误");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 拒绝请求
     * @param responseId
     * @return 拒绝请求
     */
    @GetMapping("/reject")
    public ResponseEntity<Object> rejectResponse(@RequestParam("responseId") Integer responseId){
        try {
            int result = responseService.reviseStatus(responseId, Response.STATUS_REJECTED);
            if(result == 1){
                return new ResponseEntity<>(null, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(null, HttpStatus.CREATED);
            }
        }catch (Exception e){
            HashMap<String, Object> response = new HashMap<>();
            response.put("msg", "服务器错误");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 同意请求
     * @param responseId
     * @return 同意请求处理
     */
    @GetMapping("/agree")
    public ResponseEntity<Object> agreeResponse(@RequestParam("requestId") Integer responseId){
        try {
            int result = responseService.reviseStatus(responseId, Response.STATUS_ACCEPTED);
            if(result == 1){
                return new ResponseEntity<>(null, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(null, HttpStatus.CREATED);
            }
        }catch (Exception e){
            HashMap<String, Object> response = new HashMap<>();
            response.put("msg", "服务器错误");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}