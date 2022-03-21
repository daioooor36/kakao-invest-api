package com.kakao.invest.service.product;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {

    public List<ProductDto> findProducts() {
        return List.of(ProductDto.of(1L, "12344", 11L, LocalDateTime.now(), LocalDateTime.now()));
    }
}
