package com.example.formattimeservice.rest.controllers.impl;

import com.example.formattimeservice.rest.controllers.FormatDateTimeController;
import com.example.formattimeservice.services.model.dto.DateTimeDto;
import com.example.formattimeservice.services.DatabaseClientService;
import com.example.formattimeservice.services.FormatDateTimeService;
import com.example.kafkaproducer.service.ProducerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/format")
@AllArgsConstructor
public class FormatDateTimeControllerImpl implements FormatDateTimeController {

    private final FormatDateTimeService formatDateTimeService;
    private final DatabaseClientService databaseClientService;
    private final ProducerService producerService;

    @Override
    @PostMapping(value = "/sendDateTime")
    @ResponseStatus(HttpStatus.CREATED)
    public void sendDateTime(@RequestBody DateTimeDto dto) {
        String formattedDateTime = formatDateTimeService.formatDateTime(dto);
        databaseClientService.sendValue(formattedDateTime);
        producerService.produce(formattedDateTime);
    }
}
