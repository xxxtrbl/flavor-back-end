package com.wxyql.flavorbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wxyql.flavorbackend.beans.MonthlyMoney;
import com.wxyql.flavorbackend.beans.MonthlyNum;
import com.wxyql.flavorbackend.beans.ReportsInfo;
import com.wxyql.flavorbackend.beans.SearchCondition;
import com.wxyql.flavorbackend.entity.Bargain;
import com.wxyql.flavorbackend.entity.Report;

/**
 * 统计服务接口
 * @author wxy, yql
 */

public interface IStatisticService extends IService<Report> {

    /**
     * <p>有新的成功响应, 将其数据统计到对应的(时间/城市一致)Report中</p>
     *
     * @return 添加成功 1, 否则0
     */
    int addBargainToReport(Bargain bargain);

    /**
     * <p>获取某地区最近三个月的报表信息</p>
     *
     * @return 添加成功 1, 否则0
     */
    ReportsInfo getLatestThreeMonthsReports(String city);

    /**
     * <p>根据起始日期和地点筛选报表信息</p>
     *
     * @return 获取到对应的表单
     */
    ReportsInfo getReportsByConditions(SearchCondition conditions);

    /**
     * <p>按月统计成交量</p>
     *
     * @return 每个月对应的成交量
     */
    MonthlyNum getTotalNumOrderedByMonth();

    /**
     * <p>按月统计成交金额</p>
     *
     * @return 每个月对应的成交金额
     */
    MonthlyMoney getReportsOrderedByMoney();
}