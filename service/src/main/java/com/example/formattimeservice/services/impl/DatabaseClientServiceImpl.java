package com.example.formattimeservice.services.impl;

import com.example.formattimeservice.services.DatabaseClientHttpClient;
import com.example.formattimeservice.services.DatabaseClientService;
import com.example.formattimeservice.services.model.dto.ExternalValueDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DatabaseClientServiceImpl implements DatabaseClientService {

    private final DatabaseClientHttpClient databaseClientHttpClient;
    private final String source;

    public DatabaseClientServiceImpl(
            DatabaseClientHttpClient databaseClientHttpClient,
            @Value("${service.name}") String source) {
        this.databaseClientHttpClient = databaseClientHttpClient;
        this.source = source;
    }

    @Override
    public void sendValue(String value) {
        databaseClientHttpClient.sendExternalValue(new ExternalValueDto(value, source));
    }
}
