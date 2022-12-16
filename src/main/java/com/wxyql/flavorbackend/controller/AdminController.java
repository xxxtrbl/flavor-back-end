package com.wxyql.flavorbackend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wxyql.flavorbackend.beans.*;
import com.wxyql.flavorbackend.entity.Bargain;
import com.wxyql.flavorbackend.entity.Report;
import com.wxyql.flavorbackend.entity.User;
import com.wxyql.flavorbackend.service.IStatisticService;
import com.wxyql.flavorbackend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 管理员相关请求响应
 * @author wxy, yql
 */

@RestController
@CrossOrigin
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
     * <p>有新的成功响应, 将其数据统计到对应的(时间/城市一致)Report中</p>
     * @param bargain 交易信息
     * @return 成功或失败信息
     */
    @PostMapping("/addBargainToReport")
    public ResponseEntity<Object> addBargainToReport(@RequestBody Bargain bargain){
        try {
            int result = statisticService.addBargainToReport(bargain);
            if(result == 1){
                return new ResponseEntity<>(null, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(null, HttpStatus.CREATED);
            }
        }catch (Exception e){
            e.printStackTrace();
            HashMap<String, Object> response = new HashMap<>();
            response.put("msg", "服务器错误");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
    public ResponseEntity<Object> getNumAndMoneyByMonth(@RequestParam("startMonth") Integer startMonth,
                                                        @RequestParam("startYear") Integer startYear,
                                                        @RequestParam("endMonth") Integer endMonth,
                                                        @RequestParam("endYear") Integer endYear,
                                                        @RequestParam("city") String city){
        try {
            QueryWrapper<Report> wrapper = new QueryWrapper<>();
            wrapper.eq("city", city);
            List<Report> reports = statisticService.list(wrapper);
            HashMap<Month, MonthlyData> monthData = new HashMap<>();
            for(Report report : reports){
                int reportYear = report.getYear();
                int reportMonth = report.getMonth();
                if(startYear*12+startMonth > reportYear*12+reportMonth ||
                        endYear*12+endMonth < reportYear*12+reportMonth){
                    continue;
                }
                Month month = new Month(reportYear, report.getMonth());
                MonthlyData monthlyData = monthData.get(month);
                if(monthlyData == null){
                    monthlyData = new MonthlyData();
                    monthlyData.setMonth(new Month(report.getYear(), report.getMonth()));
                    monthData.put(monthlyData.getMonth(), monthlyData);
                    monthlyData.setNumber(0);
                    monthlyData.setMoney(0);
                }
                monthlyData.setNumber(monthlyData.getNumber() + report.getRespondNum());
                monthlyData.setMoney(monthlyData.getMoney() + report.getTotalMoney());
            }

            return new ResponseEntity<>(monthData.values(), HttpStatus.OK);
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
