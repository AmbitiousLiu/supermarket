package com.example.supermarket.ljy.domain

import lombok.Data

import java.sql.Date

/**
 * @author jleo
 * @date 2020/4/27
 */
@Data
class Commodity {
    String cnum
    String name
    String sort
    Date p_date
    Date safe_date
    Integer stock_count
    Integer shelf_count
    Integer price_in
    Integer price_out
}
