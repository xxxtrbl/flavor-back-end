package com.wxyql.flavorbackend.controller;

import com.wxyql.flavorbackend.beans.SearchCondition;
import com.wxyql.flavorbackend.beans.UsersInfo;
import com.wxyql.flavorbackend.entity.User;
import com.wxyql.flavorbackend.service.IStatisticService;
import com.wxyql.flavorbackend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * 管理员相关请求响应
 * @author wxy
 */

@RestController
@Controller
@RequestMapping("/admin")
public class AdminController {
    private final IStatisticService statisticService;
    private final IUserService userService;

    @Autowired
    public AdminController(IStatisticService statisticService,
                           IUserService userService) {
        this.statisticService = statisticService;
        this.userService = userService;
    }

    /**
     * 获得近三个月某城市的报表结果
     * @param city 城市
     * @return 报表结果
     */
    @GetMapping("/recentReportsByCity")
    public ResponseEntity<Object> GetRecentThreeMonths(@RequestParam("city") String city){
        return null;
    }

    /**
     * 获取所有用户(可选)
     * @return 所有用户的信息
     */
    @GetMapping("/users")
    public ResponseEntity<Object> GetAllUsers(){
        try {
            UsersInfo users = userService.getAllUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        }catch (Exception e){
            HashMap<String, Object> response = new HashMap<>();
            response.put("msg", "服务器错误");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 获取按月获取的数量和成交量(默认最多返回过去12个月的)
     * @return 按月获取的数量和成交量(默认最多返回过去12个月的)
     */
    @GetMapping("/groupByMonth")
    public ResponseEntity<Object> GetNumAndMoneyByMonth(){
        return null;
    }

    /**
     * 获取根据搜索条件过滤的报表
     * @param searchCondition 搜索条件
     * @return 根据搜索条件过滤的报表
     */
    @GetMapping("/selectByTime")
    public ResponseEntity<Object> GetReportsByConditions(@RequestParam("condition")SearchCondition searchCondition){
        return null;
    }
}
