package com.kakao.invest.entity;

import com.kakao.invest.model.InvestStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    private Long investingAmount;

    @Enumerated(EnumType.STRING)
    private InvestStatus investStatus;

    private LocalDateTime investedAt;

    public Investment(Product product, Long investingAmount, InvestStatus investStatus, LocalDateTime investedAt) {
        this.product = product;
        this.investingAmount = investingAmount;
        this.investStatus = investStatus;
        this.investedAt = investedAt;
    }
}
