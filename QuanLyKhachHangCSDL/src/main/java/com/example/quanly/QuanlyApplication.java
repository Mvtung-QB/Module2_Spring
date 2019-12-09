package com.example.quanly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.example.quanly.repository")
@EntityScan("com.example.quanly.entity")
@SpringBootApplication
public class QuanlyApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuanlyApplication.class, args);
    }

}
