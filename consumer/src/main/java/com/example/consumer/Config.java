package com.example.consumer;

import com.example.consumer.directexchange.*;
import com.example.consumer.ejemplo.Consumer;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class Config {

    public final ObjectMapper objectMapper;

    public DefaultExchangeConsumer defaultExchangeConsumer() {
        return new DefaultExchangeConsumer();
    }


    public DirectExchangeConsumer directExchangeConsumer() {
        return new DirectExchangeConsumer();
    }


    public FanoutExchangeConsumer fanoutExchangeConsumer() {
        return new FanoutExchangeConsumer();
    }


    public TopicExchangeConsumer topicExchangeConsumer() {
        return new TopicExchangeConsumer();
    }

    @Bean
    public HeaderExchangeConsumer headerExchangeConsumer(){
        return new HeaderExchangeConsumer();
    }

    public Consumer consumer() {
        return new Consumer(objectMapper);
    }
}
