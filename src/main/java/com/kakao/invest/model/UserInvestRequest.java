package com.kakao.invest.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Positive;

@Getter
@AllArgsConstructor
public class UserInvestRequest {

    @Positive
    private Long investingAmount;
}
