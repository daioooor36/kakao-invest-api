package com.kakao.invest.service.product;

import com.kakao.invest.entity.Product;
import com.kakao.invest.model.ProductStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductDto {

    private Long productId;
    private String title;
    private Long totalInvestingAmount;
    private Long investCount;
    private ProductStatus productStatus;
    private LocalDateTime startedAt;
    private LocalDateTime finishedAt;

    private ProductDto(Long productId, String title, Long totalInvestingAmount, Long investCount, ProductStatus productStatus, LocalDateTime startedAt, LocalDateTime finishedAt) {
        this.productId = productId;
        this.title = title;
        this.totalInvestingAmount = totalInvestingAmount;
        this.investCount = investCount;
        this.productStatus = productStatus;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
    }

    public static ProductDto of(Long productId, String title, Long totalInvestingAmount, Long investCount, ProductStatus productStatus, LocalDateTime startedAt, LocalDateTime finishedAt) {
        return new ProductDto(productId, title, totalInvestingAmount, investCount, productStatus, startedAt, finishedAt);
    }

    public static ProductDto of(Product product) {
        return new ProductDto(product.getId(),
                product.getTitle(),
                product.getTotalInvestingAmount(),
                product.getInvestCount(),
                product.getProductStatus(),
                product.getStartedAt(),
                product.getFinishedAt());
    }
}
