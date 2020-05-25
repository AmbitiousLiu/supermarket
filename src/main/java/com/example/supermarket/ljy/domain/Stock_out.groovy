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
}
