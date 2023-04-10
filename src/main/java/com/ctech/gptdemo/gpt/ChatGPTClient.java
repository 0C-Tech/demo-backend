package com.ctech.gptdemo.gpt;

import com.alibaba.fastjson2.JSON;
import com.ctech.gptdemo.module.ChatRequest;
import com.ctech.gptdemo.module.ChatResponse;
import com.ctech.gptdemo.module.Message;
import com.sun.mail.util.BASE64DecoderStream;
import com.thoughtworks.xstream.core.util.*;
import okhttp3.*;
import org.springframework.stereotype.Component;

import javax.crypto.*;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
@Component
public class ChatGPTClient {
    private static String base64Sk = "c2stZzJoU2FkMGdHZDMwSGVhcVRDazBUM0JsYmtGSmRzWlpkZzFRR2JyN0V6dG0zNlFT";
    public String key(){
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(base64Sk.getBytes());
            BASE64DecoderStream decoderStream = new BASE64DecoderStream(byteArrayInputStream);
            String decoded = new String(decoderStream.readAllBytes());
            return decoded;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public  ChatResponse sendMsg(String message) throws Exception {
        Message msg = new Message();
        msg.setContent(message);
        msg.setRole("user");
        List<Message> list = new ArrayList<>();
        list.add(msg);
        ChatRequest request = new ChatRequest();
        request.setMessages(list);
        request.setModel("gpt-3.5-turbo");
        return sendMsg(request);
    }

    public  ChatResponse sendMsg(ChatRequest request) throws Exception {
        if (request.getModel() == null){
            request.setModel("gpt-3.5-turbo");
        }
        String json = JSON.toJSONString(request);
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(1200, TimeUnit.SECONDS).writeTimeout(1200, TimeUnit.SECONDS).readTimeout(1200, TimeUnit.SECONDS)
                .callTimeout(1200, TimeUnit.SECONDS).build();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, json);
        Request req = new Request.Builder()
                .url("https://api.openai.com/v1/chat/completions")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer "+key())
                .build();
        Response response = client.newCall(req).execute();
        ChatResponse resp = JSON.parseObject(response.body().string(), ChatResponse.class);
        return resp;
    }
}