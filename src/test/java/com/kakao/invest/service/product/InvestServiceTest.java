package com.kakao.invest.service.product;

import com.kakao.invest.model.ProductResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureWebMvc
@AutoConfigureMockMvc
public class InvestServiceTest {

    private final String PRODUCT_FIND_ALL_V1 = "/v1/invest/products";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    private static ProductResponse productResponseFixture;

    @BeforeAll
    static void init() {
        productResponseFixture = ProductFixture.testProduct();
    }

    @Test
    void 전체_투자상품_조회() throws Exception {
        given(productService.findAll()).willReturn(List.of(productResponseFixture));
        mockMvc.perform(get(PRODUCT_FIND_ALL_V1).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].productId").value(productResponseFixture.getProductId()))
                .andExpect(jsonPath("$.[0].title").value(productResponseFixture.getTitle()))
                .andExpect(jsonPath("$.[0].totalInvestingAmount").value(productResponseFixture.getTotalInvestingAmount()))
                .andExpect(jsonPath("$.[0].investCount").value(productResponseFixture.getInvestCount()))
                .andExpect(jsonPath("$.[0].investStatus").value(productResponseFixture.getInvestStatus().name()))
                .andReturn();
    }
}
