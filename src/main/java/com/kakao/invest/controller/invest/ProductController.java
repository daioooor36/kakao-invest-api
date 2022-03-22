package com.kakao.invest.controller.invest;

import com.kakao.invest.model.ProductResponse;
import com.kakao.invest.model.UserInvestRequest;
import com.kakao.invest.model.UserInvestResponse;
import com.kakao.invest.service.product.InvestDomainService;
import com.kakao.invest.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/invest")
public class ProductController {

    private final ProductService productService;
    private final InvestDomainService investDomainService;

    @GetMapping("/products")
    public List<ProductResponse> getAllEvents() {
        return productService.findAll();
    }

    @PostMapping("/product/{productId:[0-9]+}")
    public UserInvestResponse invest(@RequestHeader("X-USER-ID") Long userId,
                                     @PathVariable Long productId,
                                     @Valid @RequestBody UserInvestRequest userInvestRequest) throws InterruptedException {
        return investDomainService.invest(userId, productId, userInvestRequest);
    }

    @GetMapping("/my")
    public List<ProductResponse> getMyProducts(@RequestHeader("X-USER-ID") Long userId) {
        return investDomainService.findMyProducts(userId);
    }
}
