package com.kafka.Spring_boot_messaging.kafka;


import com.kafka.Spring_boot_messaging.model.User;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Data
@Service
public class KafkaConsumer {

    private String receivedMesssage;
    private User user;


//    @KafkaListener(topics = "my-topic",groupId = "myGroup")
//    public void readMessage(String message){
//        this.receivedMesssage = message;
//    }

    @KafkaListener(topics = "json-topic",groupId = "myGroup")
    public void getJson(User user){
        this.user = user;
    }
}
