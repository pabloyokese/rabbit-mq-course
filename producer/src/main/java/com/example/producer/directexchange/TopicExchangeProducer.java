package com.example.producer.directexchange;

import com.example.producer.dto.Report;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Log4j2
@Service
public class TopicExchangeProducer {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public void sendMessage() {
        List<String> origenes = Arrays.asList("marketing", "contabilidad", "ventas");
        List<String> tamanio = Arrays.asList("grande", "normal");
        List<String> tipo = Arrays.asList("doc", "zip", "png", "jpge");

        IntStream.range(0, 10)
                .mapToObj(item -> {
                    int indexOrigen = ThreadLocalRandom.current().nextInt(origenes.size());
                    int indexTamanio = ThreadLocalRandom.current().nextInt(tamanio.size());
                    int indexTipo = ThreadLocalRandom.current().nextInt(tipo.size());
                    return new Report(origenes.get(indexOrigen), tamanio.get(indexTamanio), tipo.get(indexTipo));
                })
                .forEach(item -> {
                    String routingKey = item.getOrigen() + "." + item.getTamanio() + "." + item.getTipo();
                    try {
                        String mensaje = objectMapper.writeValueAsString(item);
                        rabbitTemplate.convertAndSend("x.topic-exchange", routingKey, mensaje);
                        log.info("sending message with routingkey {}", routingKey);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException("Error to process json", e);
                    }

                });


        log.info("Sending message to x.topic-exchange ");
    }
}
