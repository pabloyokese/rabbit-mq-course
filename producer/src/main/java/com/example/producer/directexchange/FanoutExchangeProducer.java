package com.example.producer.directexchange;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Log4j2
@Service
public class FanoutExchangeProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage() {
        rabbitTemplate.convertAndSend("x.fanout-exchange", "", "Message for all!");
        log.info("Sending a message to all queues for this exchange");
    }
}
