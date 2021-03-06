package com.example.consumer.exchange;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RequiredArgsConstructor
@Log4j2
public class TopicExchangeConsumer {


    @RabbitListener(queues = {"q.imagen", "q.log", "q.zip", "q.documento"})
    public void consumeMessage(Message message) {
        log.info("Recibiendo mensaje from {} con el mensaje {}", message.getMessageProperties().getConsumerQueue(), new String(message.getBody()));
    }
}
