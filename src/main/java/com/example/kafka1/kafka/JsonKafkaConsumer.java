package com.example.kafka1.kafka;

import com.example.kafka1.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "topic2", groupId = "group_id")
    public void consumeMessage(User user) {
        logger.info(String.format("#### -> Consumed message -> %s", user.toString()));
    }

}
