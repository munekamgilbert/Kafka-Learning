package com.example.kafka1.contoller;

import com.example.kafka1.kafka.JsonKafkaProducer;
import com.example.kafka1.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/kafkajsonmessage")
public class JsonMessageController {

    private JsonKafkaProducer jsonKafkaProducer;

    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    //http:localhost:8080/api/vi/kafkajsonmessage/publish

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json Message sent to KafkaTopic");
    }


}
