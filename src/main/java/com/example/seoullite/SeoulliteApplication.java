package com.example.seoullite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SeoulliteApplication {
    // https://twer.tistory.com/entry/Spring-Security-%EA%B8%B0%EB%8A%A5%EC%9D%84-%EC%A0%9C%EA%B1%B0%ED%95%98%EB%8A%94-%EA%B0%84%EB%8B%A8%ED%95%9C-%EB%B0%A9%EB%B2%95
    public static void main(String[] args) {
        SpringApplication.run(SeoulliteApplication.class, args);
    }

}
