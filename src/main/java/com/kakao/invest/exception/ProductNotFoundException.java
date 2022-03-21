package com.kakao.invest.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
        super("제품이 존재하지 않습니다.");
    }
}
