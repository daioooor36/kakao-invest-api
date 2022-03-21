package com.kakao.invest.service.product;

import com.kakao.invest.entity.Product;
import com.kakao.invest.model.UserInvestRequest;
import com.kakao.invest.model.UserInvestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class InvestDomainService {

    private final ProductService productService;
    private final InvestService investService;

    @Transactional
    public UserInvestResponse invest(String userId, Long productId, UserInvestRequest userInvestRequest) {
        Product product = productService.findProduct(productId);
        return investService.invest(userId, product, userInvestRequest);
    }
}
