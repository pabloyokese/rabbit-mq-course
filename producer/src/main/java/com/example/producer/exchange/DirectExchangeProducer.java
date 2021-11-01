package com.example.producer.exchange;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Log4j2
@Service
public class DirectExchangeProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessageDirectExchange() {
        String message = "This message is only for admin queue";
        rabbitTemplate.convertAndSend("x.direct-exchange", "admin", message);
        log.info("Sending message only to admin");
    }
}
