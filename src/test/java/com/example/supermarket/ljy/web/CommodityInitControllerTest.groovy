package com.example.supermarket.ljy.web

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

/**
 * @author jleo
 * @date 2020/4/28
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class CommodityInitControllerTest {

    @Autowired
    WebApplicationContext wac;

    MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void testInitCommodity() {
        println this.mockMvc.perform(MockMvcRequestBuilders.get("/commodity/commodity"))
                .andReturn()
                .getResponse()
                .getContentAsString()
    }
}
