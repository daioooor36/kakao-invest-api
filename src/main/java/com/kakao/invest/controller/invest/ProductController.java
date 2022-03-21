package com.kakao.invest.controller.invest;

import com.kakao.invest.model.UserInvestRequest;
import com.kakao.invest.model.UserInvestResponse;
import com.kakao.invest.service.product.InvestDomainService;
import com.kakao.invest.service.product.ProductDto;
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
    public List<ProductDto> getAllEvents() {
        return productService.findProducts();
    }

    @PostMapping("/product/{productId:[0-9]+}")
    public UserInvestResponse invest(@RequestHeader("X-USER-ID") String userId,
                                     @PathVariable Long productId,
                                     @Valid @RequestBody UserInvestRequest userInvestRequest) {
        return investDomainService.invest(userId, productId, userInvestRequest);
    }
}
