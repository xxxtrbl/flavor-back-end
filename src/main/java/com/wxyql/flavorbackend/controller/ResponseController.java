package com.wxyql.flavorbackend.controller;

import com.wxyql.flavorbackend.beans.RequestsInfo;
import com.wxyql.flavorbackend.beans.ResponsesInfo;
import com.wxyql.flavorbackend.entity.Bargain;
import com.wxyql.flavorbackend.entity.Request;
import com.wxyql.flavorbackend.entity.Response;
import com.wxyql.flavorbackend.service.IBargainService;
import com.wxyql.flavorbackend.service.IRequestService;
import com.wxyql.flavorbackend.service.IResponseService;
import com.wxyql.flavorbackend.service.IStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.soap.AddressingFeature;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    public final IRequestService requestService;

    @Autowired
    public ResponseController(IBargainService bargainService,
                              IResponseService responseService,
                              IStatisticService statisticService,
                              IRequestService requestService){
        this.bargainService = bargainService;
        this.responseService = responseService;
        this.statisticService = statisticService;
        this.requestService = requestService;
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
    public ResponseEntity<Object> deleteResponse(@RequestParam("id") String id){
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
    public ResponseEntity<Object> getResponseByRequestId(@RequestParam("userId") Integer id){
        try {
            ResponsesInfo result = responseService.getResponseById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            HashMap<String, Object> response = new HashMap<>();
            response.put("msg", "服务器错误");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/getResponsesByUserId")
    public ResponseEntity<Object> getResponsesByUserId(@RequestParam("id") Integer id){
        try{
            ResponsesInfo result = responseService.getResponseById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            HashMap<String, Object> response = new HashMap<>();
            response.put("msg","服务器错误");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 拒绝请求
     * @param responseId
     * @return 拒绝请求
     */
    @GetMapping("/reject")
    public ResponseEntity<Object> rejectResponse(@RequestParam("responseId") String responseId){
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
    public ResponseEntity<Object> agreeResponse(@RequestParam("responseId") String responseId){
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

    @PostMapping("/addBargain")
    public ResponseEntity<Object> addBargain(@RequestBody Bargain bargain){
        try{
            this.bargainService.addBargain(bargain);

            return new ResponseEntity<>(null,HttpStatus.OK);
        }catch (Exception e){
            HashMap<String, Object> response = new HashMap<>();
            response.put("msg", "服务器错误");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 查找用户id对应的所有响应
     * @param userId 用户id
     * @return 查找到的响应
     */
    @GetMapping("/getReceivedByUserId")
    public ResponseEntity<Object> getResponseReceivedByUserId(@RequestParam("userId") Integer userId){
        try {
            RequestsInfo requests = requestService.getRequestsByUserId(userId);
            ResponsesInfo responses = new ResponsesInfo();
            for(Request request : requests.getRequests()){
                ResponsesInfo responsesToRequest = responseService.getResponseByRequestId(request.getRequestId());
                if(responses.getResponses()==null)
                    responses.setResponses(responsesToRequest.getResponses());
                else
                    responses.getResponses().addAll(responsesToRequest.getResponses());
            }
            return new ResponseEntity<>(responses, HttpStatus.OK);
        }catch (Exception e){
            HashMap<String, Object> response = new HashMap<>();
            response.put("msg", "服务器错误");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 获取所有请品鉴
     * @return 请求处理
     */
    @GetMapping("/getAll")
    public ResponseEntity<Object> getAll(){
        try {
            ResponsesInfo responsesInfo = new ResponsesInfo();
            List<Response> responses = responseService.list();
            if(responses != null){
                responsesInfo.setResponses(responses);
            }
            else{
                responsesInfo.setResponses(new ArrayList<>());
            }
            return new ResponseEntity<>(responses, HttpStatus.OK);
        }catch (Exception e){
            HashMap<String, Object> response = new HashMap<>();
            response.put("msg", "服务器错误");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}