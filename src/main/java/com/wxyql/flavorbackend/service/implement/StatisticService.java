package com.wxyql.flavorbackend.service.implement;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxyql.flavorbackend.beans.MonthlyMoney;
import com.wxyql.flavorbackend.beans.MonthlyNum;
import com.wxyql.flavorbackend.beans.ReportsInfo;
import com.wxyql.flavorbackend.beans.SearchCondition;
import com.wxyql.flavorbackend.entity.Bargain;
import com.wxyql.flavorbackend.entity.Report;
import com.wxyql.flavorbackend.mapper.IReportMapper;
import com.wxyql.flavorbackend.service.IStatisticService;
import org.springframework.stereotype.Service;

/**
 * 统计
 * @author yql
 */

@Service
public class StatisticService extends ServiceImpl<IReportMapper, Report> implements IStatisticService {
    @Override
    public int AddBargainToReport(Bargain bargain) {
        return 0;
    }

    @Override
    public ReportsInfo GetLatestThreeMonthsReports(String city) {
        return null;
    }

    @Override
    public ReportsInfo GetReportsByConditions(SearchCondition conditions) {
        return null;
    }

    @Override
    public MonthlyNum GetTotalNumOrderedByMonth() {
        return null;
    }

    @Override
    public MonthlyMoney GetReportsOrderedByMoney() {
        return null;
    }
}
