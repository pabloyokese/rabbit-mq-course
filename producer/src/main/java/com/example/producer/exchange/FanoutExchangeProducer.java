package com.example.producer.exchange;


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
        rabbitTemplate.convertAndSend("x.fanout-exchange", "", "Mensaje para todos!");
        log.info("Enviando mensaje a todas las queues de este exchange");
    }
}
