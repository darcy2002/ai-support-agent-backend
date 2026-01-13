package com.devanshi.aiagent.backend.engine.impl;

import com.devanshi.aiagent.backend.engine.AnswerEngine;
import com.devanshi.aiagent.backend.repository.KnowledgeBaseRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class KnowledgeBaseAnswerEngine implements AnswerEngine {

    private final KnowledgeBaseRepository repository;

    public KnowledgeBaseAnswerEngine(KnowledgeBaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public String generateAnswer(String question) {

        return repository.findAll()
                .stream()
                .filter(kb -> kb.getQuestion()
                        .toLowerCase()
                        .contains(question.toLowerCase()))
                .findFirst()
                .map(kb -> kb.getAnswer())
                .orElse(
                        "I don't have an answer yet. An admin can add this.");
    }

}
