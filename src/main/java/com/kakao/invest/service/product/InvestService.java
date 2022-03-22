package com.kakao.invest.service.product;

import com.kakao.invest.entity.Investment;
import com.kakao.invest.entity.InvestmentFactory;
import com.kakao.invest.entity.Product;
import com.kakao.invest.model.InvestStatus;
import com.kakao.invest.model.UserInvestRequest;
import com.kakao.invest.model.UserInvestResponse;
import com.kakao.invest.repository.product.InvestmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InvestService {

    private final InvestmentRepository investmentRepository;

    @Transactional
    public UserInvestResponse invest(Long userId, Product product, UserInvestRequest userInvestRequest) {
        boolean investResult = product.tryInvest(userInvestRequest.getInvestingAmount());
        if (investResult == Boolean.FALSE)
            return UserInvestResponse.of(InvestStatus.FAILURE);

        Investment investment = InvestmentFactory.success(userId, product, userInvestRequest.getInvestingAmount());
        investmentRepository.save(investment);
        return UserInvestResponse.of(InvestStatus.SUCCESS);
    }

    @Transactional(readOnly = true)
    public List<Investment> findMyInvests(Long userId) {
        return investmentRepository.findAllByUserId(userId);
    }
}
