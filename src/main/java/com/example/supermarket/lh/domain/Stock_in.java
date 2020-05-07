package com.example.supermarket.lh.domain;

import lombok.Data;

import java.sql.Date;

@Data
public class Stock_in {

    String num;
    String pname;
    String cnum;
    Date indate;
    Integer sum;
    String stu_num;

}
