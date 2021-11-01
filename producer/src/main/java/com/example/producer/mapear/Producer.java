package com.example.producer.mapear;

import com.example.producer.dto.TestMensaje;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class Producer {
    private final ObjectMapper objectMapper;
    private final RabbitTemplate rabbitTemplate;


    public void sendMessageJson() {
        try {
            String mensaje = objectMapper.writeValueAsString(new TestMensaje(1l, "Hola mundo con un json"));
            rabbitTemplate.convertAndSend("q.tiempoReal", mensaje);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al procesar el json", e);
        }
    }
}

