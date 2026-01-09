package com.devanshi.aiagent.backend.service;

import org.springframework.stereotype.Service;

@Service

public class AskServiceImpl implements AskService {

    @Override
    public String processQuestion(String question) {
        // placeholder logic for now
        return "You asked: " + question;
    }
}
