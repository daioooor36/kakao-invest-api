package com.kakao.invest.entity.product;

public enum InvestStatus {
    INVESTING("모집중"),
    COMPLETE("모집완료");

    private final String displayName;

    InvestStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
