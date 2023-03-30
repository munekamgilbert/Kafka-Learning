package com.example.kafkaproducerwikimedia.kafkaconfig;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    public NewTopic wikimediaTopic() {
       // return new NewTopic("wikimedia-topic", 3, (short) 1);

        return TopicBuilder.name("wikimedia-topic")
                .partitions(3)
                .replicas(1)
                .build();


    }

    public NewTopic wikimediaTopic2() {
        // return new NewTopic("wikimedia-topic", 3, (short) 1);

        return TopicBuilder.name("wikimedia-topic2")
                .partitions(3)
                .replicas(1)
                .build();


    }
}
