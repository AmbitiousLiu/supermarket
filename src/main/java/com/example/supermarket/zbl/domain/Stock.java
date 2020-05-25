package com.example.supermarket.zbl.domain;

import lombok.Data;

import java.sql.Date;
@Data
public class Stock  {
    private String cnum;
    private String name;
    private String region;
    private Integer count;
    private Integer price_in;
    private Date   p_date;
    private String safe_date;

    public Stock() {
    }

    public Stock(String cnum, String name, String region, Integer count, Integer price_in, Date p_date, String safe_date) {
        this.cnum = cnum;
        this.name = name;
        this.region = region;
        this.count = count;
        this.price_in = price_in;
        this.p_date = p_date;
        this.safe_date = safe_date;
    }

    public String getCnum() {
        return cnum;
    }

    public void setCnum(String cnum) {
        this.cnum = cnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPrice_in() {
        return price_in;
    }

    public void setPrice_in(Integer price_in) {
        this.price_in = price_in;
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
}
