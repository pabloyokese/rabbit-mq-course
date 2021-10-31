package com.example.consumer.directexchange;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RequiredArgsConstructor
@Log4j2
public class FanoutExchangeConsumer {


    @RabbitListener(queues = {"q.admin", "q.admin2", "q.accounting", "q.marketing"})
    public void consumeMessage(Message message) {
        log.info("Recibiendo mensaje from {} con el mensaje {}", message.getMessageProperties().getConsumerQueue(), new String(message.getBody()));
    }
}
