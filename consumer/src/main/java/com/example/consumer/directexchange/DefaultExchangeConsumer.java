package com.example.consumer.directexchange;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RequiredArgsConstructor
@Log4j2
public class DefaultExchangeConsumer {

    @RabbitListener(queues = "q.helloworld")
    public void getMessage(String message) {
        log.info("Obteniendo message {}", message);
    }
}
