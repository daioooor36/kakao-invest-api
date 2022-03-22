package com.kakao.invest.model;

import com.kakao.invest.entity.Product;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
public class InvestmentDto {

    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    private Long investingAmount;

    @Enumerated(EnumType.STRING)
    private InvestStatus investStatus;

    private LocalDateTime investedAt;

    public InvestmentDto(Product product, Long investingAmount, InvestStatus investStatus, LocalDateTime investedAt) {
        this.product = product;
        this.investingAmount = investingAmount;
        this.investStatus = investStatus;
        this.investedAt = investedAt;
    }
}
