package com.wxyql.flavorbackend.controller;

import com.wxyql.flavorbackend.entity.Response;
import com.wxyql.flavorbackend.entity.User;
import com.wxyql.flavorbackend.service.IUserService;
import com.wxyql.flavorbackend.service.implement.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * 用户相关请求响应
 * @author wxy, yql
 */

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService){
        this.userService = userService;
    }

    /**
     * 注册
     * @param user
     * @return 成功:OK 失败:FORBIDDEN 错误:INTERNAL_SERVER_ERR
     */
    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody User user){
        try {
            int result = userService.addUser(user);
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
     * 登录
     * @param id 用户名
     * @param password 密码
     * @return 成功:OK 失败:FORBIDDEN 错误:INTERNAL_SERVER_ERR
     */
    @GetMapping("/logIn")
    public ResponseEntity<Object> login(@RequestParam("id")Integer id,@RequestParam("password") String password){
        try {
            int result = userService.login(id, password);
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
     * 修改密码
     * @param id 用户标识
     * @param newPwd 用户密码
     * @return 成功:OK 失败:FORBIDDEN 错误:INTERNAL_SERVER_ERR
     */
    @GetMapping("/revisePwd")
    public ResponseEntity<Object> revisePwd(@RequestParam("id")Integer id, @RequestParam("newPwd") String newPwd){
        try {
            int result = userService.revisePassword(id, newPwd);
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
     * 修改电话号码
     * @param id 用户标识
     * @param newPhone 新电话号码
     * @return 成功:OK 失败:FORBIDDEN 错误:INTERNAL_SERVER_ERR
     */
    @GetMapping("/revisePhone")
    public ResponseEntity<Object> revisePhone(@RequestParam("id")Integer id, @RequestParam("newPhone") String newPhone){
        try {
            int result = userService.reviseTelephone(id, newPhone);
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

    @GetMapping("/reviseIntro")
    public ResponseEntity<Object> reviseIntro(@RequestParam("id")Integer id, @RequestParam("newIntro") String newIntro){
        try {
            int result = userService.reviseIntro(id, newIntro);
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

    @GetMapping("/info")
    public ResponseEntity<Object> getInfo(@RequestParam("id") Integer id){
        try {
            User result = userService.getUserById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            HashMap<String, Object> response = new HashMap<>();
            response.put("msg", "服务器错误");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}