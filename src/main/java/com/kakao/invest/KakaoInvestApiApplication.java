package com.kakao.invest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.kakao.invest.repository")
@SpringBootApplication
public class KakaoInvestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(KakaoInvestApiApplication.class, args);
    }

}
