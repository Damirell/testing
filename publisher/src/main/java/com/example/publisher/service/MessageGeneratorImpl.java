package com.example.publisher.service;

import com.example.publisher.dto.Action;
import com.example.publisher.dto.MessageDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class MessageGeneratorImpl implements MessageGenerator {

    private static final Random RANDOM = new Random();
    private static final Action[] ACTION_VALUES = Action.values();

    @Override
    public MessageDto generate() {
        return MessageDto.builder()
                .msisdn(RANDOM.nextInt(Integer.MAX_VALUE) + 1)
                .action(ACTION_VALUES[RANDOM.nextInt(ACTION_VALUES.length)])
                .timestamp(LocalDateTime.now())
                .build();
    }

}
