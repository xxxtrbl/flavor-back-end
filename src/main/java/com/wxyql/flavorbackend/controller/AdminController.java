package com.wxyql.flavorbackend.controller;

import com.wxyql.flavorbackend.beans.SearchCondition;
import com.wxyql.flavorbackend.service.IStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequestMapping("/admin")
public class AdminController {
    private final IStatisticService statisticService;

    @Autowired
    public AdminController(IStatisticService statisticService)
    {
        this.statisticService = statisticService;
    }

    /**
     * 获得近三个月某城市的报表结果
     * @param city
     * @return
     */
    @GetMapping("/recentReportsByCity")
    public ResponseEntity<Object> GetRecentThreeMonths(@RequestParam("city") String city){

    }

    /**
     * 获取所有用户(可选)
     * @return 所有用户的信息
     */
    @GetMapping("/users")
    public ResponseEntity<Object> GetAllUsers(){

    }

    /**
     * 获取按月获取的数量和成交量(默认最多返回过去12个月的)
     * @return 按月获取的数量和成交量(默认最多返回过去12个月的)
     */
    @GetMapping("/groupByMonth")
    public ResponseEntity<Object> GetNumAndMoneyByMonth(){

    }

    /**
     * 获取根据搜索条件过滤的报表
     * @param searchCondition 搜索条件
     * @return 根据搜索条件过滤的报表
     */
    @GetMapping("/selectByTime")
    public ResponseEntity<Object> GetReportsByConditions(@RequestParam("condition")SearchCondition searchCondition){

    }
}
