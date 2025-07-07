package com.kafka.Spring_boot_messaging.controller;

import com.kafka.Spring_boot_messaging.kafka.KafkaConsumer;
import com.kafka.Spring_boot_messaging.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class MessageConsumer {

    private KafkaConsumer kafkaConsumer;

    public MessageConsumer(KafkaConsumer kafkaConsumer) {
        this.kafkaConsumer = kafkaConsumer;
    }

    @GetMapping("getMessage")
    public ResponseEntity<String> generateMessage(){
        return ResponseEntity.ok("message received:"+kafkaConsumer.getReceivedMesssage());
    }

    @GetMapping("getJsonMessage")
    public ResponseEntity<User> message(){
        return ResponseEntity.status(HttpStatus.OK).body(kafkaConsumer.getUser());
    }
}
