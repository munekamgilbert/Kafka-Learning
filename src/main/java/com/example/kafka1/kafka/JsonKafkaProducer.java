package com.example.kafka1.kafka;

import com.example.kafka1.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
    private static final Logger logger = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, String> kafkaTemplate;
    public JsonKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

public void sendMessage(User data) {
    logger.info(String.format("#### -> Producing message -> %s", data.toString()));

    Message<User> message = MessageBuilder
            .withPayload(data)
            .setHeader(KafkaHeaders.TOPIC, "topic2")
            .build();

    kafkaTemplate.send(message);
    }

}
