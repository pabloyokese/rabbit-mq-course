package com.example.producer;

import com.example.producer.exchange.*;
import com.example.producer.mapear.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@RequiredArgsConstructor
@EnableScheduling
public class ProducerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    private final Producer producer;
    private final DefaultExchangeProducer defaultExchangeProducer;
    private final DirectExchangeProducer directExchangeProducer;
    private final FanoutExchangeProducer fanoutExchangeProducer;
    private final TopicExchangeProducer topicExchangeProducer;
    private final HeaderExchangeProducer headerExchangeProducer;

    @Override
    public void run(String... args) throws Exception {
        //        producer.sendMessageJson();
//        defaultExchangeProducer.sendMessageDirectExchange();
//        directExchangeProducer.sendMessageDirectExchange();
//        fanoutExchangeProducer.sendMessage();
//        topicExchangeProducer.sendMessage();
//        headerExchangeProducer.sendMessage();
    }
}

