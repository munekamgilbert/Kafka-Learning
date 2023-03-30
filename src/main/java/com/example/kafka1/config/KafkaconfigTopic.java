package com.example.kafka1.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@EnableKafka
public class KafkaconfigTopic {
    @Bean
    public NewTopic topic1() {
          return TopicBuilder.name("topic1")
                 .partitions(10)
                 .replicas(1)
                 .build();
    }

    @Bean
    public NewTopic topic2() {
        return TopicBuilder.name("topic2")
                .partitions(10)
                .replicas(1)
                .build();
    }
}
