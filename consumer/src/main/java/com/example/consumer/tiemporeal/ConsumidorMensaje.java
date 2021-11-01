package com.example.consumer.tiemporeal;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Log4j2
public class ConsumidorMensaje {

    @RabbitListener(queues = "q.tiemporeal")
    public void getMessage(String message) {
        log.info("Recibiendo mensaje {}", message);
    }

}
