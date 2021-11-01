package com.example.producer.tiemporeal;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Log4j2
@RequiredArgsConstructor
public class ProductorMensaje {

    private final RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 10 * 1000)
    public void produceMessage() {
        LocalDateTime now = LocalDateTime.now();
        rabbitTemplate.convertAndSend("q.tiemporeal",now.toString());
        log.info("Produciendo mensaje a las {}", now);
    }
}
