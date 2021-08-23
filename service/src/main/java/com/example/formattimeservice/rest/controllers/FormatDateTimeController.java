package com.example.formattimeservice.rest.controllers;

import com.example.formattimeservice.services.model.dto.DateTimeDto;

public interface FormatDateTimeController {
    void sendDateTime(DateTimeDto dto);
}
