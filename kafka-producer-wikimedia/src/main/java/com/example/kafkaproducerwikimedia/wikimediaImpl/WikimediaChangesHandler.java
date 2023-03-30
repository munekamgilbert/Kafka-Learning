package com.example.kafkaproducerwikimedia.wikimediaImpl;


import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;


import static org.springframework.kafka.listener.ConsumerAwareRebalanceListener.LOGGER;



public class WikimediaChangesHandler implements EventHandler {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(WikimediaChangesHandler.class);

    private KafkaTemplate<String, String> kafkaTemplate;
    String topic = "wikimedia-topic";

    public WikimediaChangesHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String event, MessageEvent messageEvent) throws Exception {
           LOGGER.info(String.format("Received message: %s", messageEvent.getData()));
        //   System.out.println("Received message: " + messageEvent.getData());
              kafkaTemplate.send(topic, messageEvent.getData());
    }

    @Override
    public void onComment(String comment) throws Exception {

    }

    @Override
    public void onError(Throwable t) {

    }
}
