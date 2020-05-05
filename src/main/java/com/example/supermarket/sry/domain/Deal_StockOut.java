package com.example.supermarket.sry.domain;

import lombok.Data;

import java.sql.Date;

@Data
public class Deal_StockOut {
    String num;
    String pname;
    String cnum;
    Date outdate;
    Integer price;
    Integer sum;
    String stu_num;
}
