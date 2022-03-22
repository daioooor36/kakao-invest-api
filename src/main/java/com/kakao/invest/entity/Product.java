package com.kakao.invest.entity;

import com.kakao.invest.model.ProductStatus;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static java.lang.Thread.sleep;

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

    public boolean tryInvest(Long investingAmount) throws InterruptedException {
        sleep(10_000L);
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

    public boolean isSoldOut() {
        return this.currentAmount > this.totalAmount;
    }
}
