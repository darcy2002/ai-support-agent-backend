package com.devanshi.aiagent.backend.service;

import com.devanshi.aiagent.backend.engine.AnswerEngine;
import org.springframework.stereotype.Service;

@Service
public class AskServiceImpl implements AskService {

    private final AnswerEngine answerEngine;

    public AskServiceImpl(AnswerEngine answerEngine) {
        this.answerEngine = answerEngine;
    }

    @Override
    public String processQuestion(String question) {
        return answerEngine.generateAnswer(question);
    }
}
