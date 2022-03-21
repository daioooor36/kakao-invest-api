package com.kakao.invest.entity.product;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String title;

    private Long totalInvestingAmount;

    private Long investCount;

    private InvestStatus investStatus;

    private LocalDateTime startedAt;

    private LocalDateTime finishedAt;
}
