package com.example.supermarket.lh.domain;

import lombok.Data;

import java.sql.Date;

@Data
public class Stock_in {
    String num;

    public void setNum(String num) {
        this.num = num;
    }

    public void setPname(String pname) {
        this.pname = pname;
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

    String pname;
    String cnum;
    Date indate;
    Integer sum;
    String stu_num;

    public String getNum() {
        return num;
    }

    public String getPname() {
        return pname;
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
