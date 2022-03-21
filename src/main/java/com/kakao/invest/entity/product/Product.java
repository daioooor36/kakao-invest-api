package com.kakao.invest.entity.product;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Entity
public class Product {

    @Id
    private Long productId;

    private String title;

    private Long totalInvestingAmount;

    private Long investCount;

    private InvestStatus investStatus;

    private LocalDateTime startedAt;

    private LocalDateTime finishedAt;
}
