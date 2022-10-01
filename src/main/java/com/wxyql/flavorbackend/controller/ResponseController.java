package com.wxyql.flavorbackend.controller;

import com.wxyql.flavorbackend.entity.Response;
import com.wxyql.flavorbackend.service.IBarginService;
import com.wxyql.flavorbackend.service.IResponseService;
import com.wxyql.flavorbackend.service.IStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@RequestMapping("/response")
public class ResponseController {
    public final IBarginService barginService;
    public final IResponseService responseService;
    public final IStatisticService statisticService;

    @Autowired
    public ResponseController(IBarginService barginService, IResponseService responseService, IStatisticService statisticService){
        this.barginService = barginService;
        this.responseService = responseService;
        this.statisticService = statisticService;
    }


    @PostMapping("/add")
    public ResponseEntity<Object> AddResponse(@RequestBody Response reponse) {

    }

    @GetMapping("/delete")
    public ResponseEntity<Object> DeleteResponse(@RequestParam("id") Integer id){

    }

    @PostMapping("/revise")
    public ResponseEntity<Object> ReviseResponse(@RequestBody Response response){

    }

    /**
     * 根据请求id获取对应的响应
     * @param id
     * @return 请求id对应的响应
     */
    @GetMapping("/getById")
    public ResponseEntity<Object> GetResponseByRequestId(@RequestParam("requestId") Integer id){

    }

    /**
     * 拒绝请求
     * @param responseId
     * @return 拒绝请求
     */
    @GetMapping("/reject")
    public ResponseEntity<Object> RejectReponse(@RequestParam("responseId") Integer responseId){

    }

    /**
     * 同意请求
     * @param responseId
     * @return 同意请求处理
     */
    @GetMapping("/agree")
    public ResponseEntity<Object> AgreeResponse(@RequestParam("requestId") Integer responseId){

    }

}