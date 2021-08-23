package com.example.formattimeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.kafkaproducer", "com.example.formattimeservice"})
public class FormatDateTimeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormatDateTimeServiceApplication.class, args);
    }

}