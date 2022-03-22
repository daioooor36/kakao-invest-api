package com.kakao.invest.service.product;

import com.kakao.invest.entity.Investment;
import com.kakao.invest.entity.Product;
import com.kakao.invest.model.ProductResponse;
import com.kakao.invest.model.UserInvestRequest;
import com.kakao.invest.model.UserInvestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class InvestDomainService {

    private final ProductService productService;
    private final InvestService investService;

    @Transactional
    public UserInvestResponse invest(Long userId, Long productId, UserInvestRequest userInvestRequest) {
        Product product = productService.findOne(productId);
        return investService.invest(userId, product, userInvestRequest);
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> findMyProducts(Long userId) {
        List<Investment> myInvestments = investService.findMyInvests(userId);

        return myInvestments.stream()
                .map(investment -> investment.getProduct())
                .map(ProductResponse::of)
                .distinct()
                .collect(Collectors.toList());
    }
}
