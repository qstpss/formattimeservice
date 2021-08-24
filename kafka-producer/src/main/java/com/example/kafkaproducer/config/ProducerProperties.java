package com.example.kafkaproducer.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("producer")
@Getter
@Setter
public class ProducerProperties {
    private String server;
    private String topic;
}
