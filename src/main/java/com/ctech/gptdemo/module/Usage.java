package com.ctech.gptdemo.module;

public class Usage {
    Long prompt_tokens;
    Long completion_tokens;
    Long total_tokens;

     public Long getPrompt_tokens() {
          return prompt_tokens;
     }

     public void setPrompt_tokens(Long prompt_tokens) {
          this.prompt_tokens = prompt_tokens;
     }

     public Long getCompletion_tokens() {
          return completion_tokens;
     }

     public void setCompletion_tokens(Long completion_tokens) {
          this.completion_tokens = completion_tokens;
     }

     public Long getTotal_tokens() {
          return total_tokens;
     }

     public void setTotal_tokens(Long total_tokens) {
          this.total_tokens = total_tokens;
     }
}
