package com.example.kafkaproducer.service.impl;

import com.example.kafkaproducer.config.ProducerProperties;
import com.example.kafkaproducer.model.ExternalValueDto;
import com.example.kafkaproducer.service.ProducerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ProducerProperties producerProperties;
    private final ObjectMapper objectMapper;
    private static final String PAYLOAD = "payloadType";

    @Override
    @SneakyThrows
    @Async
    public void produce(String value) {
        ExternalValueDto dto = new ExternalValueDto();
        dto.setValue(value);
        System.out.println("#############SEND A MESSAGE#########");

        String payload = objectMapper.writeValueAsString(dto);
        Message<String> message = MessageBuilder
                .withPayload(payload)
                .setHeader(KafkaHeaders.TOPIC, producerProperties.getTopic())
                .setHeader(PAYLOAD, dto.getClass().getName())
                .build();

        kafkaTemplate.send(message);
    }
}
