package com.example.kafkaproducer;

import com.example.kafkaproducer.config.ProducerConfiguration;
import com.example.kafkaproducer.config.ProducerProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest({"producer.name=Hello", "producer.server=0.0.0.0"})
@ContextConfiguration(classes=ProducerConfiguration.class)
public class ProducerTest {

    @Autowired
    private ProducerProperties producerProperties;

    @Test
    public void contextLoads() {
        assertThat(producerProperties.getName()).isEqualTo("Hello");
        assertThat(producerProperties.getServer()).isEqualTo("0.0.0.0");
    }
}
