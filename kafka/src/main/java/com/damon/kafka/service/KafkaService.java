package com.damon.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaService() {
    }

    public void SendMessage(String key, String value) {
        this.kafkaTemplate.send("skynet.topic", key, value);
    }
}