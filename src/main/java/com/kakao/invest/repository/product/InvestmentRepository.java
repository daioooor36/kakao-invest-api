package com.kakao.invest.repository.product;

import com.kakao.invest.entity.Investment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {

    List<Investment> findAllByUserId(Long userId);
}
