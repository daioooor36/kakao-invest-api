package com.kakao.invest.model;

public enum InvestStatus {
    SUCCESS("투자 완료"),
    FAILURE("투자 불가");

    private final String displayName;

    public String getDisplayName() {
        return displayName;
    }

    InvestStatus(String displayName) {
        this.displayName = displayName;
    }
}
