package com.example.formattimeservice.services.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateTimeDto {
    private ZonedDateTime dateTime;
}
