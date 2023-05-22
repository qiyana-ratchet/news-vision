package com.example.newsvision.support.chatgpt.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatCompletionResponseBody {


    @JsonProperty(value = "id")
    public String id;
    @JsonProperty(value = "object")
    public String object;
    @JsonProperty(value = "created")
    public Long created;
    @JsonProperty(value = "model")
    public String model;
    @JsonProperty(value = "choices")
    public List<Choice> choices;
    @JsonProperty(value = "usage")
    public Usage usage;

    @Data
    public static class Choice{
        @JsonProperty(value = "index")
        public Integer index;
        @JsonProperty(value = "message")
        public Message message;
        @JsonProperty(value = "finish_reason")
        public String finishReason;
    }

    @Data
    public static class Usage{
        @JsonProperty(value = "prompt_tokens")
        public Integer promptTokens;
        @JsonProperty(value = "completion_tokens")
        public Integer completionTokens;
        @JsonProperty(value = "total_tokens")
        public Integer totalTokens;

    }
}
