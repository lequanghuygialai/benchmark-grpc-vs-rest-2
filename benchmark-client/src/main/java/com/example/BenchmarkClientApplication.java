package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class BenchmarkClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(BenchmarkClientApplication.class, args);
    }
}
