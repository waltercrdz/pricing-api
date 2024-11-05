package com.waltercrdz.api.pricing.in.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PriceControllerTest {

    private static final String URI_TEMPLATE = "/products/{product_id}/prices?date={date}&brand_id={brand_id}";
    private static final String URI_TEMPLATE_WITHOUT_BRAND_ID = "/products/{product_id}/prices?date={date}";

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeAll
    void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    @DisplayName("When product_id=35455&date=2020-06-14T10:00:00Z&brand_id=1 should return 35.50 price")
    public void test1() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get(URI_TEMPLATE, 35455, "2020-06-14T10:00:00Z", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.product_id").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price_list").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.start_date").value("2020-06-14T00:00:00Z"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.end_date").value("2020-12-31T23:59:59Z"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.50));
    }

    @Test
    @DisplayName("When product_id=35455&date=2020-06-14T16:00:00Z&brand_id=1 should return 25.45 price")
    public void test2() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get(URI_TEMPLATE, 35455, "2020-06-14T16:00:00Z", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.product_id").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price_list").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.start_date").value("2020-06-14T15:00:00Z"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.end_date").value("2020-06-14T18:30:00Z"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(25.45))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency").value("EUR"));
    }

    @Test
    @DisplayName("When product_id=35455&date=2020-06-14T21:00:00Z&brand_id=1 should return 35.50 price")
    public void test3() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get(URI_TEMPLATE, 35455, "2020-06-14T21:00:00Z", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.product_id").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price_list").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.start_date").value("2020-06-14T00:00:00Z"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.end_date").value("2020-12-31T23:59:59Z"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.50))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency").value("EUR"));
    }

    @Test
    @DisplayName("When product_id=35455&date=2020-06-15T10:00:00Z&brand_id=1 should return 30.50 price")
    public void test4() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get(URI_TEMPLATE, 35455, "2020-06-15T10:00:00Z", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.product_id").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price_list").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.start_date").value("2020-06-15T00:00:00Z"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.end_date").value("2020-06-15T11:00:00Z"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(30.50))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency").value("EUR"));
    }

    @Test
    @DisplayName("When product_id=35455&date=2020-06-16T21:00:00Z&brand_id=1 should return 38.95 price")
    public void test5() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get(URI_TEMPLATE, 35455, "2020-06-16T21:00:00Z", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.product_id").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price_list").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$.start_date").value("2020-06-15T16:00:00Z"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.end_date").value("2020-12-31T23:59:59Z"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(38.95))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currency").value("EUR"));
    }

    @Test
    @DisplayName("When invalid date should return 404 not found")
    public void test6() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get(URI_TEMPLATE, 35455, "2019-06-16T21:00:00Z", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("When invalid product should return 404 not found")
    public void test7() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get(URI_TEMPLATE, 12345, "2020-06-16T21:00:00Z", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("When invalid brand should return 404 not found")
    public void test8() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get(URI_TEMPLATE, 35455, "2020-06-16T21:00:00Z", 2)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("When not send brand should return 400 bad request")
    public void test9() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get(URI_TEMPLATE_WITHOUT_BRAND_ID, 35455, "2020-06-16T21:00:00Z")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}