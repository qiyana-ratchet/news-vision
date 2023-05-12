package com.example.newsvision.support.chatgpt;


import com.example.newsvision.support.chatgpt.entity.ChatCompletionRequestBody;
import com.example.newsvision.support.chatgpt.entity.ChatCompletionResponseBody;
import com.example.newsvision.support.chatgpt.entity.Message;
import com.example.newsvision.support.chatgpt.exception.BizException;
import com.example.newsvision.support.chatgpt.exception.Error;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

import java.util.ArrayList;
import java.util.List;

import static com.example.newsvision.support.chatgpt.entity.Constant.*;

@Slf4j
@Getter
@Setter
@Builder
public class ChatGpt {
    private final String apiKey;
    private String apiHost = DEFAULT_CHAT_COMPLETION_API_URL;
    protected OkHttpClient client;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ChatGpt(final String apiKey)
    {
        this.apiKey = apiKey;
        this.client = new OkHttpClient();

    }

    public ChatGpt(String apiKey, OkHttpClient client) {
        this.apiKey = apiKey;
        this.client = client;
    }

    public ChatGpt(String apiKey, Proxy proxy) {
        this.apiKey = apiKey;
        client = new OkHttpClient.Builder().proxy(proxy).build();
    }


    public ChatGpt(String apiHost, String apiKey) {
        this.apiHost = apiHost;
        this.apiKey = apiKey;
        this.client = new OkHttpClient();
    }

    public ChatGpt(String apiHost, String apiKey, OkHttpClient client) {
        this.apiHost = apiHost;
        this.apiKey = apiKey;
        this.client = client;
    }

    public ChatGpt(String apiHost, String apiKey, Proxy proxy) {
        this.apiHost = apiHost;
        this.apiKey = apiKey;
        client = new OkHttpClient.Builder().proxy(proxy).build();
    }


    public ChatGpt(String apiHost, String apiKey, String proxyHost, int proxyPort) {
        this.apiHost = apiHost;
        this.apiKey = apiKey;
        client = new OkHttpClient.Builder().
                proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort)))
                .build();
    }




    public String ask(String input){
        return ask(DEFAULT_MODEL.getName(), DEFAULT_USER, input);
    }

    private String buildRequestBody(String model, String role, String content){
        try{
            List<Message> messages = new ArrayList<>();
            messages.add(Message.builder().role(role).content(content).build());
            ChatCompletionRequestBody requestBody = ChatCompletionRequestBody.builder()
                    .model(model)
                    .messages(messages)
                    .build();
            return objectMapper.writeValueAsString(requestBody);

        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }

    public ChatCompletionResponseBody askOriginal(String model, String role, String content) {
        RequestBody body = RequestBody.create(buildRequestBody(model, role, content), MediaType.get("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(apiHost)
                .header("Authorization", "Bearer " + apiKey)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                if (response.body() == null) {
                    log.error("Request failed: {}, please try again", response.message());
                    throw new BizException(response.code(), "Request failed");
                } else {
                    log.error("Request failed: {}, please try again", response.body().string());
                    throw new BizException(response.code(), response.body().string());
                }
            } else {
                assert response.body() != null;
                String bodyString = response.body().string();
                return objectMapper.readValue(bodyString, ChatCompletionResponseBody.class);
            }
        } catch (IOException e) {
            log.error("Request failed: {}", e.getMessage());
            throw new BizException(Error.SERVER_HAD_AN_ERROR.getCode(), e.getMessage());

        }
    }

    public String ask(String model,String role, String content){
        ChatCompletionResponseBody chatCompletionResponseBody = askOriginal(model,role,content);
        List<ChatCompletionResponseBody.Choice> choices = chatCompletionResponseBody.getChoices();
        StringBuilder result = new StringBuilder();
        for(ChatCompletionResponseBody.Choice choice: choices){
            result.append(choice.getMessage().getContent());
        }
        return result.toString();
    }




}
