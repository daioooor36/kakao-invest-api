package com.kakao.invest.model;

import com.kakao.invest.entity.Product;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductResponse {

    private Long productId;
    private String title;
    private Long totalInvestingAmount;
    private Long investCount;
    private ProductStatus productStatus;
    private LocalDateTime startedAt;
    private LocalDateTime finishedAt;

    private ProductResponse(Long productId, String title, Long totalInvestingAmount, Long investCount, ProductStatus productStatus, LocalDateTime startedAt, LocalDateTime finishedAt) {
        this.productId = productId;
        this.title = title;
        this.totalInvestingAmount = totalInvestingAmount;
        this.investCount = investCount;
        this.productStatus = productStatus;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
    }

    public static ProductResponse of(Long productId, String title, Long totalInvestingAmount, Long investCount, ProductStatus productStatus, LocalDateTime startedAt, LocalDateTime finishedAt) {
        return new ProductResponse(productId, title, totalInvestingAmount, investCount, productStatus, startedAt, finishedAt);
    }

    public static ProductResponse of(Product product) {
        return new ProductResponse(product.getProductId(),
                product.getTitle(),
                product.getTotalAmount(),
                product.getInvestCount(),
                product.getProductStatus(),
                product.getStartedAt(),
                product.getFinishedAt());
    }
}
