package com.kakao.invest.service.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class ProductDto {

    private Long productId;

    private String title;

    private Long totalInvestingAmount;

    private LocalDateTime startedAt;

    private LocalDateTime finishedAt;

    private ProductDto(Long productId, String title, Long totalInvestingAmount, LocalDateTime startedAt, LocalDateTime finishedAt) {
        this.productId = productId;
        this.title = title;
        this.totalInvestingAmount = totalInvestingAmount;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
    }

    public static ProductDto of(Long productId, String title, Long totalInvestingAmount, LocalDateTime startedAt, LocalDateTime finishedAt) {
        return new ProductDto(productId, title, totalInvestingAmount, startedAt, finishedAt);
    }
}
