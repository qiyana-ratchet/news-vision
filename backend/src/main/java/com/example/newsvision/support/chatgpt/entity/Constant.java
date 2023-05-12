package com.example.newsvision.support.chatgpt.entity;

public class Constant {
    private Constant(){}
        /**
         * Chat completion API URL
         * <p>
         * see: <a href=https://platform.openai.com/docs/api-reference/chat/create>https://platform.openai.com/docs/api-reference/chat/create</a>
         */
        public static final String DEFAULT_CHAT_COMPLETION_API_URL = "https://api.openai.com/v1/chat/completions";
        public static final String DEFAULT_USER = "user";
        public static final Model DEFAULT_MODEL = Model.GPT_3_5_TURBO;


}
