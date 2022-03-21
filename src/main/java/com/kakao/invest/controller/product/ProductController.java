package com.kakao.invest.controller.product;

import com.kakao.invest.service.product.ProductDto;
import com.kakao.invest.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/invest/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("")
    public List<ProductDto> findEvents() {
        return productService.findProducts();
    }
}
