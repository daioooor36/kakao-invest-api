package com.kakao.invest.entity;

import com.kakao.invest.model.InvestStatus;

import java.time.LocalDateTime;

public class InvestmentFactory {

    public static Investment success(Long userId, Product product, Long investingAmount) {
        return new Investment(userId, product, investingAmount, InvestStatus.SUCCESS, LocalDateTime.now());
    }
}
