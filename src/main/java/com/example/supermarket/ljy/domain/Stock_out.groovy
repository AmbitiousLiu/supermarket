package com.example.supermarket.ljy.domain

import lombok.Data

import java.sql.Date

/**
 * @author jleo
 * @date 2020/4/30
 */
@Data
class Stock_out {
    String num
    String cnum
    Date outdate
    Integer sum
    String stu_num
    String region
    String name;
    String cname;

    Stock_out() {
    }

    Stock_out(String num, String cnum, Date outdate, Integer sum, String stu_num, String region, String name, String cname) {
        this.num = num
        this.cnum = cnum
        this.outdate = outdate
        this.sum = sum
        this.stu_num = stu_num
        this.region = region
        this.name = name
        this.cname = cname
    }

    String getNum() {
        return num
    }

    void setNum(String num) {
        this.num = num
    }

    String getCnum() {
        return cnum
    }

    void setCnum(String cnum) {
        this.cnum = cnum
    }

    Date getOutdate() {
        return outdate
    }

    void setOutdate(Date outdate) {
        this.outdate = outdate
    }

    Integer getSum() {
        return sum
    }

    void setSum(Integer sum) {
        this.sum = sum
    }

    String getStu_num() {
        return stu_num
    }

    void setStu_num(String stu_num) {
        this.stu_num = stu_num
    }

    String getRegion() {
        return region
    }

    void setRegion(String region) {
        this.region = region
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    String getCname() {
        return cname
    }

    void setCname(String cname) {
        this.cname = cname
    }

    @Override
    public String toString() {
        return "Stock_out{" +
                "num='" + num + '\'' +
                ", cnum='" + cnum + '\'' +
                ", outdate=" + outdate +
                ", sum=" + sum +
                ", stu_num='" + stu_num + '\'' +
                ", region='" + region + '\'' +
                ", name='" + name + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }
}
