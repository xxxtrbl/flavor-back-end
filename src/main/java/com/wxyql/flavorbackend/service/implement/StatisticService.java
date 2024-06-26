package com.wxyql.flavorbackend.service.implement;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxyql.flavorbackend.beans.*;
import com.wxyql.flavorbackend.entity.Bargain;
import com.wxyql.flavorbackend.entity.Report;
import com.wxyql.flavorbackend.mapper.IReportMapper;
import com.wxyql.flavorbackend.service.IStatisticService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 统计
 * @author yql
 */

@Service
public class StatisticService extends ServiceImpl<IReportMapper, Report> implements IStatisticService {
    @Override
    public int addBargainToReport(Bargain bargain) {
        // 获取交易对应城市
        String city = bargain.getCity();
        // 获取交易时间
        Date date = bargain.getSuccessDate();
        // 提取交易时间年月信息
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime());
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);

        // 查找对应请品鉴记录是否存在
        QueryWrapper<Report> responseWrapper = new QueryWrapper<>();
        responseWrapper.eq("yy", year)
                .eq("mm", month)
                .eq("city", city)
                .eq("responseType", Report.RESPONSE_TYPE_RESPONSE);
        Report responseReport = getOne(responseWrapper);
        if(responseReport == null) {
            responseReport = new Report();
            responseReport.setYear(year);
            responseReport.setMonth(month);
            responseReport.setCity(city);
            responseReport.setResponseType(Report.RESPONSE_TYPE_RESPONSE);
            responseReport.setRespondNum(0);
            responseReport.setTotalMoney(0);
        }

        // 查找对应寻味道记录是否存在
        QueryWrapper<Report> requestWrapper = new QueryWrapper<>();
        requestWrapper.eq("yy", year)
                .eq("mm", month)
                .eq("city", city)
                .eq("responseType", Report.RESPONSE_TYPE_REQUEST);
        Report requestReport = getOne(responseWrapper);
        if(requestReport == null){
            requestReport = new Report();
            requestReport.setYear(year);
            requestReport.setMonth(month);
            requestReport.setCity(city);
            requestReport.setResponseType(Report.RESPONSE_TYPE_REQUEST);
            requestReport.setRespondNum(0);
            requestReport.setTotalMoney(0);
        }

        // 更新，计数+1，数额+3或1
        responseReport.setRespondNum(responseReport.getRespondNum() + 1);
        responseReport.setTotalMoney(responseReport.getTotalMoney() + Report.RESPONSE_PRICE);

        requestReport.setRespondNum(requestReport.getRespondNum() + 1);
        requestReport.setTotalMoney(responseReport.getTotalMoney() + Report.REQUEST_PRICE);

        // 写回数据库
        saveOrUpdate(responseReport);
        saveOrUpdate(requestReport);

        return 1;
    }

    @Override
    public ReportsInfo getLatestThreeMonthsReports(String city) {
        Date dateNow = new Date();
        // 提取当前时间年月信息
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(dateNow.getTime());
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);

        ReportsInfo result = new ReportsInfo();
        result.setReports(new ArrayList<>());
        for(int i = 0; i < 3; i++){
            QueryWrapper<Report> wrapper = new QueryWrapper<>();
            wrapper.eq("city", city)
                    .eq("month", month)
                    .eq("year", year);

            Report report = getOne(wrapper);
            if(report != null){
                result.getReports().add(report);
            }

            month--;
            if(month <= 0){
                month += 12;
                year--;
            }
        }

        return result;
    }

    @Override
    public ReportsInfo getReportsByConditions(SearchCondition conditions) {
        ReportsInfo result = new ReportsInfo();
        result.setReports(new ArrayList<>());

        int year = conditions.getEndMonth().getYear();
        int month = conditions.getEndMonth().getMonth();
        int startYear = conditions.getStartMonth().getYear();
        int startMonth = conditions.getStartMonth().getMonth();
        while(year > startYear || month >= startMonth){
            QueryWrapper<Report> wrapper = new QueryWrapper<>();
            wrapper.eq("city", conditions.getCity())
                    .eq("month", month)
                    .eq("year", year);

            Report report = getOne(wrapper);
            if(report != null){
                result.getReports().add(report);
            }

            month--;
            if(month <= 0){
                month += 12;
                year--;
            }
        }
        return result;
    }
}
