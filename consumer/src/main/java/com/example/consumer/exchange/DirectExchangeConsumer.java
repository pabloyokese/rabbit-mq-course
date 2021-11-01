package com.example.consumer.exchange;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RequiredArgsConstructor
@Log4j2
public class DirectExchangeConsumer {

    @RabbitListener(queues = {"q.admin", "q.admin2"})
    public void obtenerMessageFromQueueAdmin(Message message) {
        log.info("Consumiendo mensajes {} {}", message.getMessageProperties().getConsumerQueue(), new String(message.getBody()));
    }
}
