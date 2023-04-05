package com.ctech.gptdemo.module;

import java.util.List;

public class ChatResponse {

    /***
     * {"id":"chatcmpl-71sakVaBcZc87g5vnc5bEFW39czvo",
     * "object":"chat.completion",
     * "created":1680682534,
     * "model":"gpt-3.5-turbo-0301",
     * "usage":{
     * "prompt_tokens":44,
     * "completion_tokens":201,
     * "total_tokens":245
     * },
     * "choices":[
     * {
         * "message":{
         *          "role":"assistant",
         *          "content":"要调用Java代码中的chat接口，需要使用Java HTTP客户端库，例如Apache HttpClient或OkHttp。您需要使用HTTP POST请求将输入文本发送到https://api.openai.com/v1/chat/completions接口，并将身份验证标头添加到请求中。该接口将返回包含生成的文本响应的HTTP响应。您可以解析响应并显示生成的文本回答。\n\n综上所述，您需要编写Java代码来执行以下操作：\n\n1.创建HTTP POST请求并将其发送到https://api.openai.com/v1/chat/completions。\n\n2.添加必要的授权标头来通过OpenAI API进行身份验证。\n\n3.解析响应并从中提取生成的文本响应。\n\n4.将文本响应显示给用户或执行其他可能的操作。"
         *          },
         * "finish_reason":"stop",
         * "index":0
     * }
     * ]}
     */
    String id;
    String object;
    Long created;
    String model;
    Usage usage;
    List<Choice>  choices;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
}
