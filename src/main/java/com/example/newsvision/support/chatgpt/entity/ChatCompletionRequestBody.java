package com.example.newsvision.support.chatgpt.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChatCompletionRequestBody {

    @JsonProperty(value = "model")
    private String model;

    @JsonProperty(value = "messages")
    private List<Message> messages;


    private String user;

}
