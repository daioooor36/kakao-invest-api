package com.kakao.invest.service.product;

import com.kakao.invest.entity.Product;
import com.kakao.invest.exception.ProductNotFoundException;
import com.kakao.invest.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDto> findProducts() {
        final LocalDateTime now = LocalDateTime.now();
        List<Product> availableProducts = productRepository.findAllByStartedAtLessThanEqualAndFinishedAtGreaterThanEqual(now, now);

        return availableProducts.stream()
                .map(ProductDto::of)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Product findProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
    }
}
