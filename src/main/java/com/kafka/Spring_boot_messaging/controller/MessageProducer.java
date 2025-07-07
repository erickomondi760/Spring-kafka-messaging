package com.kafka.Spring_boot_messaging.controller;

import com.kafka.Spring_boot_messaging.kafka.KafkaProducer;
import com.kafka.Spring_boot_messaging.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class MessageProducer {

    private KafkaProducer kafkaProducer;

    public MessageProducer(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

//    @GetMapping("message")
//    public ResponseEntity<String> generateMessage(@RequestParam("message") String message){
//        kafkaProducer.sendMessage(message);
//        return ResponseEntity.ok("message sent");
//    }

    @PostMapping("json")
    public ResponseEntity<String> sendMessage(@RequestBody User user){
        kafkaProducer.sendObject(user);
        return ResponseEntity.ok("Json message sent");
    }
}
