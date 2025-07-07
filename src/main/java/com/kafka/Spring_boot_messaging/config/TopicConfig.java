package com.kafka.Spring_boot_messaging.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {

    @Bean
    public NewTopic createTopic(){
        return TopicBuilder.name("my-topic").build();
    }

    @Bean
    public NewTopic jsonTopic(){
        return TopicBuilder.name("json-topic").build();
    }
}
