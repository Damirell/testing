package com.example.publisher.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MessageDto {
    @JsonProperty("msisdsn")
    private Integer msisdsn;

    @JsonProperty("action")
    private Action action;

    @JsonProperty("timestamp")
    private Long timestamp;
}
