package com.wxyql.flavorbackend.controller;

import com.wxyql.flavorbackend.beans.*;
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
 * @author wxy, yql
 */

@RestController
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
    public ResponseEntity<Object> getRecentThreeMonths(@RequestParam("city") String city){
        try {
            ReportsInfo reports = statisticService.getLatestThreeMonthsReports(city);
            return new ResponseEntity<>(reports, HttpStatus.OK);
        }catch (Exception e){
            HashMap<String, Object> response = new HashMap<>();
            response.put("msg", "服务器错误");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 获取所有用户(可选)
     * @return 所有用户的信息
     */
    @GetMapping("/users")
    public ResponseEntity<Object> getAllUsers(){
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
    public ResponseEntity<Object> getNumAndMoneyByMonth(){
        try {
            MonthlyNum monthlyNum = statisticService.getTotalNumOrderedByMonth();
            MonthlyMoney monthlyMoney = statisticService.getReportsOrderedByMoney();
            HashMap<String,Object> result = new HashMap<>();
            result.put("monthlyNum", monthlyNum);
            result.put("monthlyMoney", monthlyMoney);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            HashMap<String, Object> response = new HashMap<>();
            response.put("msg", "服务器错误");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 获取根据搜索条件过滤的报表
     * @param searchCondition 搜索条件
     * @return 根据搜索条件过滤的报表
     */
    @GetMapping("/selectByTime")
    public ResponseEntity<Object> getReportsByConditions(@RequestParam("condition")SearchCondition searchCondition){
        try {
            ReportsInfo reports = statisticService.getReportsByConditions(searchCondition);
            return new ResponseEntity<>(reports, HttpStatus.OK);
        }catch (Exception e){
            HashMap<String, Object> response = new HashMap<>();
            response.put("msg", "服务器错误");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
