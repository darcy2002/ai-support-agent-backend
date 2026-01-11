package com.devanshi.aiagent.backend.engine;

import org.springframework.stereotype.Component;

@Component
public class DefaultAnswerEngine implements AnswerEngine {

    @Override
    public String generateAnswer(String question) {
        return "You asked: " + question;
    }
}
