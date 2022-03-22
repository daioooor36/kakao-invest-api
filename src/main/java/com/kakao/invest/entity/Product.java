package com.kakao.invest.entity;

import com.kakao.invest.model.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

import static java.lang.Thread.sleep;

@ToString
@Getter
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String title;

    private Long totalAmount;

    private Long currentAmount;

    private Long investCount;

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

    private LocalDateTime startedAt;

    private LocalDateTime finishedAt;

    @Version
    private int version;

    public Product(String title, Long totalAmount, Long currentAmount, Long investCount, ProductStatus productStatus, LocalDateTime startedAt, LocalDateTime finishedAt) {
        this.title = title;
        this.totalAmount = totalAmount;
        this.currentAmount = currentAmount;
        this.investCount = investCount;
        this.productStatus = productStatus;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
    }

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

    public boolean isSoldOut() {
        return this.currentAmount >= this.totalAmount;
    }
}
