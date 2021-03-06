package com.example.formattimeservice.services.impl;

import com.example.formattimeservice.services.DatabaseClientHttpClient;
import external.dto.ExternalValueDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class DatabaseClientHttpClientImpl implements DatabaseClientHttpClient {

    private final RestTemplate restTemplate;
    private final String dbServiceUrl;

    public DatabaseClientHttpClientImpl(RestTemplate restTemplate, @Value("${dbservice.baseurl}") String dbServiceUrl) {
        this.restTemplate = restTemplate;
        this.dbServiceUrl = dbServiceUrl;
    }

    @Override
    public void sendExternalValue(ExternalValueDto dto) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(dbServiceUrl);
        uriBuilder.path("/db/value");
        restTemplate.postForEntity(uriBuilder.build().toUri(), dto, Void.class);
    }


}
