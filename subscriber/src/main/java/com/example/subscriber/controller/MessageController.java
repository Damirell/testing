package com.example.subscriber.controller;

import com.example.subscriber.dto.MessageRequest;
import com.example.subscriber.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.NotNull;

@Slf4j
@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<String> handleMessage(@RequestBody @NotNull MessageRequest request) {
        messageService.handleMessage(request);

        return ResponseEntity.ok(String.format("%s successfully handled!", request.getAction()));
    }
}
