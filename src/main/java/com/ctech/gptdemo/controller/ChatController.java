package com.ctech.gptdemo.controller;

import com.alibaba.fastjson2.JSON;
import com.ctech.gptdemo.gpt.ChatGPTClient;
import com.ctech.gptdemo.module.ChatRequest;
import com.ctech.gptdemo.module.ChatRequestVo;
import com.ctech.gptdemo.module.ChatResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
public class ChatController {
    private final ChatGPTClient gptClient;
    private static final Logger LOGGER = LoggerFactory.getLogger(ChatController.class);

    @PostMapping("/sendMsg")
    ChatResponse sendMessage(@RequestBody ChatRequestVo msg){
        LOGGER.info("request got."+ JSON.toJSONString(msg));
        try {
            return gptClient.sendMsg(msg.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/sendMsgWithHistory")
    ChatResponse sendMessage(@RequestBody ChatRequest msg){
        LOGGER.info("request got."+ JSON.toJSONString(msg));
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
