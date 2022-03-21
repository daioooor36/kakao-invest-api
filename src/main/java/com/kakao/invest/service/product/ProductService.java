package com.kakao.invest.service.product;

import com.kakao.invest.entity.product.Product;
import com.kakao.invest.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDto> findProducts() {
        LocalDateTime now = LocalDateTime.now();
        List<Product> availableProducts = productRepository.findAllByStartedAtLessThanEqualAndFinishedAtGreaterThanEqual(now, now);

        return availableProducts.stream()
                .map(ProductDto::of)
                .collect(Collectors.toList());
    }
}
