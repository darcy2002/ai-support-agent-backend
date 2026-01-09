package com.devanshi.aiagent.backend.dto;

public class AskResponse {

    private String answer;

    public AskResponse(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
}
