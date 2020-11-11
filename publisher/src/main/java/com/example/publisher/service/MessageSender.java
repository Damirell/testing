package com.example.publisher.service;

import com.example.publisher.dto.MessageDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class MessageSender {
    private static final String SUBSCRIBER_URL = System.getenv("SUBSCRIBER_URL");
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final MessageGenerator messageGenerator;
    private final RestTemplate restTemplate;

    @Autowired
    public MessageSender(MessageGenerator messageGenerator,
                         RestTemplate restTemplate) {
        this.messageGenerator = messageGenerator;
        this.restTemplate = restTemplate;
    }

    public void send() {
        MessageDto message = messageGenerator.generate();
        try {
            HttpEntity<String> request = prepareRequest(message);
            restTemplate.exchange(SUBSCRIBER_URL, HttpMethod.POST, request, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private HttpEntity<String> prepareRequest(MessageDto messageDto) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new HttpEntity<>(OBJECT_MAPPER.writeValueAsString(messageDto), headers);
    }
}
