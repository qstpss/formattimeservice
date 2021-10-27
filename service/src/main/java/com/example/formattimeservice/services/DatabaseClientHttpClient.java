package com.example.formattimeservice.services;

import external.dto.ExternalValueDto;

public interface DatabaseClientHttpClient {
    void sendExternalValue(ExternalValueDto dto);
}
