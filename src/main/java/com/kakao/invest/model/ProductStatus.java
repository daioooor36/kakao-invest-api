package com.kakao.invest.model;

public enum ProductStatus {

    INVESTING("모집중"),
    SOLD_OUT("모집완료");

    private final String displayName;

    ProductStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
