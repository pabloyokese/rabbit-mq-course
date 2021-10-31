package com.example.consumer.directexchange;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RequiredArgsConstructor
@Log4j2
public class DirectExchangeConsumer {

    @RabbitListener(queues = "q.admin")
    public void obtenerMessageFromQueueAdmin(String message){
        log.info("Consumiendo mensajes q.admin {}", message);
    }
    @RabbitListener(queues = "q.admin2")
    public void obtenerMessageFromQueueAdmin2(String message){
        log.info("Consumiendo mensajes q.admin2 {}", message);
    }
}
