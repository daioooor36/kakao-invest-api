package com.kakao.invest.entity;

import com.kakao.invest.model.ProductStatus;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Long totalAmount;

    private Long currentAmount;

    private Long investCount;

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

    private LocalDateTime startedAt;

    private LocalDateTime finishedAt;

    public boolean tryInvest(Long investingAmount) {
        if(isSoldOut() || this.productStatus == ProductStatus.SOLD_OUT)
            return Boolean.FALSE;

        invest(investingAmount);
        return Boolean.TRUE;
    }

    private void invest(Long investingAmount) {
        this.currentAmount += investingAmount;
        this.investCount += 1;

        if(isSoldOut()) {
            this.productStatus = ProductStatus.SOLD_OUT;
        }
    }

    private boolean isSoldOut() {
        return this.currentAmount > this.totalAmount;
    }
}
