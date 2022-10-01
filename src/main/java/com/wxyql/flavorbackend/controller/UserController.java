package com.wxyql.flavorbackend.controller;

import com.wxyql.flavorbackend.entity.User;
import com.wxyql.flavorbackend.service.IUserService;
import com.wxyql.flavorbackend.service.implement.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
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

    }

    /**
     * 登录
     * @param nickname 用户名
     * @param password 密码
     * @return 成功:OK 失败:FORBIDDEN 错误:INTERNAL_SERVER_ERR
     */
    @GetMapping("/logIn")
    public ResponseEntity<Object> login(@RequestParam("nickname")String nickname,@RequestParam("password") String password){

    }

    /**
     * 修改密码
     * @param id 用户标识
     * @param newPwd 用户密码
     * @return 成功:OK 失败:FORBIDDEN 错误:INTERNAL_SERVER_ERR
     */
    @GetMapping("/revisePwd")
    public ResponseEntity<Object> revisePwd(@RequestParam("id")Integer id, @RequestParam("newPwd") String newPwd){

    }

    /**
     * 修改电话号码
     * @param id 用户标识
     * @param newPhone 新电话号码
     * @return 成功:OK 失败:FORBIDDEN 错误:INTERNAL_SERVER_ERR
     */
    @GetMapping("/revisePhone")
    public ResponseEntity<Object> revisePhone(@RequestParam("id")Integer id, @RequestParam("newPhone") String newPhone){

    }

    @GetMapping("/reviseIntro")
    public ResponseEntity<Object> reviseIntro(@RequestParam("id")Integer id, @RequestParam("newIntro") String newIntro){

    }
}