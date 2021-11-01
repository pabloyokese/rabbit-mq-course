package com.example.producer.exchange;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Log4j2
@Service
public class DefaultExchangeProducer {
    
    private final RabbitTemplate rabbitTemplate;

    public void sendMessageDirectExchange() {
        rabbitTemplate.convertAndSend("q.defaul-exchange", "Hola mundo");
        log.info("El mensaje ha sido enviado to the queue.");
    }
}
