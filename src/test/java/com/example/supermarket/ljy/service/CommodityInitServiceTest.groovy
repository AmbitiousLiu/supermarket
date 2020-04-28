package com.example.supermarket.ljy.service

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

/**
 * @author jleo
 * @date 2020/4/27
 */
@SpringBootTest
class CommodityInitServiceTest {

    @Autowired CommodityInitService commodityInitService

    @Test
    void testGetAllCommodities() {
        println commodityInitService.getAllCommodities()
    }
}
