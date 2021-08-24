package com.example.kafkaproducer.service.impl;

import com.example.kafkaproducer.config.ProducerProperties;
import com.example.kafkaproducer.model.ExternalValueDto;
import com.example.kafkaproducer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {

    private final KafkaTemplate<Long, ExternalValueDto> kafkaTemplate;
    private final ProducerProperties producerProperties;

    @Override
    @SneakyThrows
    @Async
    public void produce(String value) {
        ExternalValueDto dto = new ExternalValueDto();
        dto.setValue(value);
        System.out.println("#############SEND A MESSAGE#########");

        ListenableFuture<SendResult<Long, ExternalValueDto>> futureResult =
                kafkaTemplate.send(producerProperties.getTopic(), dto);
        futureResult.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("Failure while sending a message");
            }

            @Override
            public void onSuccess(SendResult<Long, ExternalValueDto> longExternalValueDtoSendResult) {
                System.out.println("Message send successfully");
            }
        });

    }
}
