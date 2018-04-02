package com.hbdl.web.sys.controller.page;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by GalaIO on 2016/12/4.
 */
public class DatePage {
    private String month;
    private String year;
    private String day;
    private String orderStr;
    private List<String> yearList;
    private List<String> dayList;
    private List<String> monthList;

    /*
     *增加用 teamtypeid来识别类型，区分年份排序
     */
    private BigDecimal teamTypeID;

    public BigDecimal getTeamTypeID() {
        return teamTypeID;
    }

    public void setTeamTypeID(BigDecimal teamTypeID) {
        this.teamTypeID = teamTypeID;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getOrderStr() {
        return orderStr;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }

    public List<String> getYearList() {
        return yearList;
    }

    public void setYearList(List<String> yearList) {
        this.yearList = yearList;
    }

    public List<String> getDayList() {
        return dayList;
    }

    public void setDayList(List<String> dayList) {
        this.dayList = dayList;
    }

    public List<String> getMonthList() {
        return monthList;
    }

    public void setMonthList(List<String> monthList) {
        this.monthList = monthList;
    }
}
