package com.wxyql.flavorbackend.controller;

import com.wxyql.flavorbackend.entity.Response;
import com.wxyql.flavorbackend.service.IBargainService;
import com.wxyql.flavorbackend.service.IResponseService;
import com.wxyql.flavorbackend.service.IStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 请品鉴
 * @author wxy
 */

@RestController
@Controller
@RequestMapping("/response")
public class ResponseController {
    public final IBargainService barginService;
    public final IResponseService responseService;
    public final IStatisticService statisticService;

    @Autowired
    public ResponseController(IBargainService bargainService, IResponseService responseService, IStatisticService statisticService){
        this.barginService = bargainService;
        this.responseService = responseService;
        this.statisticService = statisticService;
    }


    @PostMapping("/add")
    public ResponseEntity<Object> AddResponse(@RequestBody Response reponse) {
        return null;
    }

    @GetMapping("/delete")
    public ResponseEntity<Object> DeleteResponse(@RequestParam("id") Integer id){
        return null;
    }

    @PostMapping("/revise")
    public ResponseEntity<Object> ReviseResponse(@RequestBody Response response){
        return null;
    }

    /**
     * 根据寻味道请求id获取对应的响应
     * @param id 寻味道请求id
     * @return 请求id对应的响应
     */
    @GetMapping("/getById")
    public ResponseEntity<Object> GetResponseByRequestId(@RequestParam("requestId") Integer id){
        return null;
    }

    /**
     * 拒绝请求
     * @param responseId
     * @return 拒绝请求
     */
    @GetMapping("/reject")
    public ResponseEntity<Object> RejectResponse(@RequestParam("responseId") Integer responseId){
        return null;
    }

    /**
     * 同意请求
     * @param responseId
     * @return 同意请求处理
     */
    @GetMapping("/agree")
    public ResponseEntity<Object> AgreeResponse(@RequestParam("requestId") Integer responseId){
        return null;
    }

}