package com.kakao.invest.service.product;

import com.kakao.invest.entity.product.InvestStatus;
import com.kakao.invest.entity.product.Product;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductDto {

    private Long productId;
    private String title;
    private Long totalInvestingAmount;
    private Long investCount;
    private InvestStatus investStatus;
    private LocalDateTime startedAt;
    private LocalDateTime finishedAt;

    private ProductDto(Long productId, String title, Long totalInvestingAmount, Long investCount, InvestStatus investStatus, LocalDateTime startedAt, LocalDateTime finishedAt) {
        this.productId = productId;
        this.title = title;
        this.totalInvestingAmount = totalInvestingAmount;
        this.investCount = investCount;
        this.investStatus = investStatus;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
    }

    public static ProductDto of(Long productId, String title, Long totalInvestingAmount, Long investCount, InvestStatus investStatus, LocalDateTime startedAt, LocalDateTime finishedAt) {
        return new ProductDto(productId, title, totalInvestingAmount, investCount, investStatus, startedAt, finishedAt);
    }

    public static ProductDto of(Product product) {
        return new ProductDto(product.getProductId(),
                product.getTitle(),
                product.getTotalInvestingAmount(),
                product.getInvestCount(),
                product.getInvestStatus(),
                product.getStartedAt(),
                product.getFinishedAt());
    }
}
