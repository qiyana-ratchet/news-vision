package com.example.newsvision.support.chatgpt.entity;


import lombok.Getter;

@Getter
public enum Model {
    GPT_4("gpt-4"),
    GPT_3_5_TURBO("gpt-3.5-turbo"),
    GPT_3_5_TURBO_0301("gpt-3.5-turbo-0301"),
    ;

    private final String name;

    Model(String name){
        this.name = name;
    }

}
