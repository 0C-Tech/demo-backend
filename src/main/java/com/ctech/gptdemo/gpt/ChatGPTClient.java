package com.ctech.gptdemo.gpt;

import com.alibaba.fastjson2.JSON;
import com.ctech.gptdemo.module.ChatRequest;
import com.ctech.gptdemo.module.ChatResponse;
import com.ctech.gptdemo.module.Message;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
@Component
public class ChatGPTClient {

    public  ChatResponse sendMsg(String message) throws Exception {
        Message msg = new Message();
        msg.setContent(message);
        msg.setRole("user");
        List<Message> list = new ArrayList<>();
        list.add(msg);
        ChatRequest request = new ChatRequest();
        request.setMessages(list);
        request.setModel("gpt-3.5-turbo");
        String json = JSON.toJSONString(request);

        OkHttpClient client = new OkHttpClient.Builder()
                .callTimeout(60, TimeUnit.SECONDS).build();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, json);
        Request req = new Request.Builder()
                .url("https://api.openai.com/v1/chat/completions")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer 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")
                .build();
        Response response = client.newCall(req).execute();
        ChatResponse resp = JSON.parseObject(response.body().string(), ChatResponse.class);
        return resp;
    }
}