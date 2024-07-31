package com.example.Avocapplogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.example.Avocapplogin")
@EntityScan(basePackages = "com.example.Avocapplogin.model")
@EnableJpaRepositories(basePackages = "com.example.Avocapplogin.repository")
public class AvocapploginApplication {

    public static void main(String[] args) {
        SpringApplication.run(AvocapploginApplication.class, args);
    }
}
