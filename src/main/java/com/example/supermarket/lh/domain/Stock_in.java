package com.example.supermarket.lh.domain;

import lombok.Data;

import java.sql.Date;

@Data
public class Stock_in {
    String num;
    String pnum;
    String cnum;
    Date indate;
    Date p_date;
    String safe_date;
    Integer sum;
    String stu_num;
    String region;
    Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setPname(String pnum) {
        this.pnum = pnum;
    }

    public void setCnum(String cnum) {
        this.cnum = cnum;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public void setStu_num(String stu_num) {
        this.stu_num = stu_num;
    }



    public Date getP_date() {
        return p_date;
    }

    public void setP_date(Date p_date) {
        this.p_date = p_date;
    }

    public String getSafe_date() {
        return safe_date;
    }

    public void setSafe_date(String safe_date) {
        this.safe_date = safe_date;
    }

    public Stock_in() {
    }

    public Stock_in(String num, String pnum, String cnum, Date indate, Date p_date, String safe_date, Integer sum, String stu_num, String region, Integer price) {
        this.num = num;
        this.pnum = pnum;
        this.cnum = cnum;
        this.indate = indate;
        this.p_date = p_date;
        this.safe_date = safe_date;
        this.sum = sum;
        this.stu_num = stu_num;
        this.region = region;
        this.price = price;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getNum() {
        return num;
    }

    public String getPnum() {
        return pnum;
    }

    public String getCnum() {
        return cnum;
    }

    public Date getIndate() {
        return indate;
    }

    public Integer getSum() {
        return sum;
    }

    public String getStu_num() {
        return stu_num;
    }
}
