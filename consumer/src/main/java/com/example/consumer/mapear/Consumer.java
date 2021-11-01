package com.example.consumer.mapear;

import com.example.consumer.dto.TestMensaje;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RequiredArgsConstructor
@Log4j2
public class Consumer {
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "q.mapper")
    public void getMessage(String message) {
        TestMensaje testMensaje = null;
        try {
            testMensaje = objectMapper.readValue(message, TestMensaje.class);
            log.info("Obteniendo message {}", testMensaje);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error procesando el json", e);
        }

    }
}
