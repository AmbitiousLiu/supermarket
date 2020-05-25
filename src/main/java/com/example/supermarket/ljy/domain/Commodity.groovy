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
    String region
    Date p_date
    String safe_date
    Integer count
    Integer price_out
}
