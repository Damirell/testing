package com.example.subscriber.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MessageRequest {
    @NotNull
    @JsonProperty("msisdsn")
    private Integer msisdsn;

    @NotNull
    @JsonProperty("action")
    private Action action;

    @NotNull
    @JsonProperty("timestamp")
    private Long timestamp;
}
