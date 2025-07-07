package com.kafka.Spring_boot_messaging.kafka;


import com.kafka.Spring_boot_messaging.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    private KafkaTemplate<String,String> kafkaTemplate;
    private KafkaTemplate<String,User> kafkaJsonTemplate;


    @Autowired
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate,
                         KafkaTemplate<String,User> kafkaJsonTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaJsonTemplate = kafkaJsonTemplate;
    }

//    public void sendMessage(String message){
//        logger.info(String.format("Message sent : %s",message));
//        kafkaTemplate.send("my-topic",message);
//    }

    public void sendObject(User user){
        Message<User> message = MessageBuilder.withPayload(user)
                .setHeader(KafkaHeaders.TOPIC,"json-topic")
                .build();
        kafkaJsonTemplate.send(message);
    }
}
