package com.kakao.invest.service.product;

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
}
