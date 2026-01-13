package com.devanshi.aiagent.backend.dto;

import jakarta.validation.constraints.NotBlank;

public class KnowledgeRequest {

    @NotBlank
    private String question;

    @NotBlank
    private String answer;

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
