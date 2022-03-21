package com.kakao.invest.repository.product;

import com.kakao.invest.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByStartedAtLessThanEqualAndFinishedAtGreaterThanEqual(LocalDateTime startedAt, LocalDateTime finishedAt);
}
