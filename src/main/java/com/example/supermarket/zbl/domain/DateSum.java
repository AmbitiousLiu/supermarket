package com.example.supermarket.zbl.domain;

import java.sql.Date;

public class DateSum {
    Date date;
    Integer count;

    @Override
    public String toString() {
        return "{" +
                "date=" + date +
                ", count=" + count +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public DateSum(Date date, Integer count) {
        this.date = date;
        this.count = count;
    }

    public DateSum() {
    }
}
