package com.example.formattimeservice.services;

import com.example.formattimeservice.services.model.dto.ExternalValueDto;

public interface DatabaseClientHttpClient {
    void sendExternalValue(ExternalValueDto dto);
}
