package com.kakao.invest.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserInvestResponse {

    private InvestStatus investStatus;

    public static UserInvestResponse of(InvestStatus investStatus) {
        return new UserInvestResponse(investStatus);
    }
}
