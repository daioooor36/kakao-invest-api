package com.kakao.invest.service;

import com.kakao.invest.entity.Product;
import com.kakao.invest.model.ProductResponse;
import com.kakao.invest.model.ProductStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ProductFixture {

    public static ProductResponse testProduct() {
        return ProductResponse.of(1L,
                "테스트",
                1000L,
                300L,
                ProductStatus.INVESTING,
                LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0)),
                LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0)));
    }

    public static Product PRODUCT_TESTER_1() {
        return new Product("테스트 상품", 350000L, 0L, 0L, ProductStatus.INVESTING,
                LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0)),
                LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0)));
    }
}
