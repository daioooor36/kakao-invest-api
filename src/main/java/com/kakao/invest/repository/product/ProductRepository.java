package com.kakao.invest.repository.product;

import com.kakao.invest.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByStartedAtLessThanEqualAndFinishedAtGreaterThanEqual(LocalDateTime startedAt, LocalDateTime finishedAt);
}
