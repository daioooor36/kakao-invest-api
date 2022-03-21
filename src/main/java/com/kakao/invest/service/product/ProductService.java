package com.kakao.invest.service.product;

import com.kakao.invest.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDto> findProducts() {
        return productRepository.findAll().stream()
                .map(ProductDto::of)
                .collect(Collectors.toList());
    }
}
