package com.example.producer.exchange;

import com.example.producer.dto.Archivo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Log4j2
@Service
public class HeaderExchangeProducer {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public void sendMessage() {
        List<String> tipos = Arrays.asList("reporte", "log");
        List<String> formatos = Arrays.asList("pdf", "zip", "log");

        IntStream.range(0, 10)
                .mapToObj(index -> {
                    int indexTipo = ThreadLocalRandom.current().nextInt(tipos.size());
                    int indexFormat = ThreadLocalRandom.current().nextInt(formatos.size());
                    return new Archivo(tipos.get(indexTipo), formatos.get(indexFormat));
                })
                .forEach(archivo -> {
                    try {
                        String mensaje = objectMapper.writeValueAsString(archivo);
                        Map<String, Object> map = new HashMap<>();
                        map.put("formato", archivo.getFormato());
                        map.put("tipo", archivo.getTipo());
                        Message message = MessageBuilder.withBody(mensaje.getBytes())
                                .copyHeaders(map)
                                .build();
                        rabbitTemplate.convertAndSend("x.headers-exchange", "", message);
                        log.info("sending message with headers message {}", archivo);

                    } catch (JsonProcessingException e) {
                        throw new RuntimeException("Error to process json", e);
                    }

                });


        log.info("Sending message to x.topic-exchange ");
    }
}

