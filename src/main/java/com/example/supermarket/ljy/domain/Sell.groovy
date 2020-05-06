package com.example.supermarket.ljy.domain

import lombok.Data

import java.sql.Date

/**
 * @author jleo
 * @date 2020/5/5
 */
@Data
class Sell {

    String cnum
    Integer count
    Date date
    Integer price_in
    Integer price_out

}
