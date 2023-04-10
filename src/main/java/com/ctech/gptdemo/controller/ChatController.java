package com.ctech.gptdemo.controller;

import com.ctech.gptdemo.gpt.ChatGPTClient;
import com.ctech.gptdemo.module.ChatRequest;
import com.ctech.gptdemo.module.ChatRequestVo;
import com.ctech.gptdemo.module.ChatResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    private final ChatGPTClient gptClient;
    @PostMapping("/sendMsg")
    ChatResponse sendMessage(@RequestBody ChatRequestVo msg){
        try {
            return gptClient.sendMsg(msg.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/sendMsgWithHistory")
    ChatResponse sendMessage(@RequestBody ChatRequest msg){
        try {
            return gptClient.sendMsg(msg);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ChatController(ChatGPTClient gptClient) {
        this.gptClient = gptClient;
    }
}
