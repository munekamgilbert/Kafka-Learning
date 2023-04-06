package com.example.kafkaconsumerdatabase.kafkadataconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class KafkaDatabaseConsumer {

    private static final Logger logger = Logger.getLogger(KafkaDatabaseConsumer.class.getName());

    @KafkaListener(topics = "wikimedia-topic", groupId = "group_id")
    public void consumeMessage(String message) {
        logger.info(String.format("Consumed message: %s", message));
    }
}
