package com.example.supermarket.zbl.domain;

import java.sql.Date;

public class FootPrints {
    private String stu_num;
    private String url;
    private Date   date;

    public FootPrints() {
    }

    @Override
    public String toString() {
        return "FootPrints{" +
                "stu_num='" + stu_num + '\'' +
                ", url='" + url + '\'' +
                ", date=" + date +
                '}';
    }

    public FootPrints(String stu_num, String url, Date date) {
        this.stu_num = stu_num;
        this.url = url;
        this.date = date;
    }

    public String getStu_num() {
        return stu_num;
    }

    public void setStu_num(String stu_num) {
        this.stu_num = stu_num;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
