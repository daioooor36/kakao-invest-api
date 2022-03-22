package com.kakao.invest.service.product;

import com.kakao.invest.entity.Product;
import com.kakao.invest.model.ProductStatus;
import com.kakao.invest.model.UserInvestRequest;
import com.kakao.invest.repository.product.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class InvestDomainServiceTest {

    private static final ExecutorService service = Executors.newFixedThreadPool(100);

    @Autowired
    private InvestDomainService investDomainService;

    @Autowired
    private ProductRepository productRepository;

    private long productId;

    @BeforeEach
    void init() {
        Product product = new Product("스레드 상품", 1000L, 0L, 0L, ProductStatus.INVESTING,
                LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0)),
                LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0)));
        product = productRepository.save(product);
        productId = product.getProductId();
    }

    @Test
    public void raceCondition_없이_동시_투자_테스트_() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            service.execute(() -> {
                investDomainService.invest(123L, productId, new UserInvestRequest(10L));
                latch.countDown();
            });
        }
        latch.await();
        Product richProduct = productRepository.findById(productId).orElseThrow();
        System.out.println("##product: " + richProduct);
        assertThat(richProduct.getCurrentAmount()).isEqualTo(10L * 100L);
    }
}
