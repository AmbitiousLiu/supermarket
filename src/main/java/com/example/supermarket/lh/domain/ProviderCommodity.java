package com.example.supermarket.lh.domain;

import lombok.Data;

import java.sql.Date;

@Data
public class ProviderCommodity {
    private String pnum;
    private String cnum;
    private String cname;
    private String region;
    private Double price;
    private Date   p_date;
    private String safe_date;

    public ProviderCommodity(String pnum, String cnum, String cname, String region, Double price, Date p_date, String safe_date) {
        this.pnum = pnum;
        this.cnum = cnum;
        this.cname = cname;
        this.region = region;
        this.price = price;
        this.p_date = p_date;
        this.safe_date = safe_date;
    }

    public String getPnum() {
        return pnum;
    }

    public void setPnum(String pnum) {
        this.pnum = pnum;
    }

    public String getCnum() {
        return cnum;
    }

    public void setCnum(String cnum) {
        this.cnum = cnum;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
