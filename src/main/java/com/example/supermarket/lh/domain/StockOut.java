package com.example.supermarket.lh.domain;

import lombok.Data;
import java.sql.Date;

@Data
public class StockOut {
    String num ;//出库单单号
    String pname; //供应商名称
    String cnum;//商品号
    Date outdate;//出库日期
    Integer price;//价格
    Integer sum;//数量
    String stu_num;//经手人
}