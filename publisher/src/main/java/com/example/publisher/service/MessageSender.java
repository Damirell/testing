package com.example.publisher.service;

import com.example.publisher.dto.MessageDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageSender {

    private static final String SUBSCRIBER_URL = System.getenv("SUB_URL");
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final MessageGenerator messageGenerator;
    private final RestTemplate restTemplate;

    public void send() {
        restTemplate.exchange(SUBSCRIBER_URL, HttpMethod.POST, prepareRequest(messageGenerator.generate()), String.class);
    }

    @SneakyThrows
    private HttpEntity<String> prepareRequest(MessageDto messageDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new HttpEntity<>(OBJECT_MAPPER.writeValueAsString(messageDto), headers);
    }
}
