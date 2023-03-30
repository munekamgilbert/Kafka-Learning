package com.example.kafka1.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class KafkaProducer {

    private static final Logger logger = Logger.getLogger(KafkaProducer.class.getName());

   private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
         this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        logger.info(String.format("#### -> Producing message -> %s", message));
        kafkaTemplate.send("topic1", message);
    }
}
