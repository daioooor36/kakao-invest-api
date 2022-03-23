package com.kakao.invest.repository;

import com.kakao.invest.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByStartedAtLessThanEqualAndFinishedAtGreaterThanEqual(LocalDateTime startedAt, LocalDateTime finishedAt);

    @Lock(LockModeType.PESSIMISTIC_FORCE_INCREMENT)
    Optional<Product> findByProductId(Long productId);
}
