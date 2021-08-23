package com.example.formattimeservice.services.impl;

import com.example.formattimeservice.services.model.dto.DateTimeDto;
import com.example.formattimeservice.services.FormatDateTimeService;
import org.springframework.stereotype.Service;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

@Service
public class FormatDateTimeServiceImpl implements FormatDateTimeService {
    private final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter
            .ofLocalizedDate(FormatStyle.LONG)
            .withLocale(Locale.ENGLISH);

    @Override
    public String formatDateTime(DateTimeDto dto) {
        return DATE_TIME_FORMATTER.format(dto.getDateTime());
    }
}
