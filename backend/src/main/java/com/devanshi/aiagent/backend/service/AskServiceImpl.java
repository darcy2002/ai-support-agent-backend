package com.devanshi.aiagent.backend.service;

import com.devanshi.aiagent.backend.engine.AnswerEngine;
import com.devanshi.aiagent.backend.entity.Conversation;
import com.devanshi.aiagent.backend.repository.ConversationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.scheduling.annotation.Async;
import java.util.concurrent.CompletableFuture;

@Service
public class AskServiceImpl implements AskService {

    private final AnswerEngine answerEngine;
    private ConversationRepository repository;

    public AskServiceImpl(
            ConversationRepository repository,
            AnswerEngine answerEngine) {
        this.repository = repository;
        this.answerEngine = answerEngine;
    }

    @Override
    @Transactional
    public String processQuestion(String question) {

        String answer = answerEngine.generateAnswer(question);

        Conversation conversation = new Conversation(question, answer);

        repository.save(conversation);

        return answer;
    }

    @Async
    @Override
    public CompletableFuture<String> processQuestionAsync(String question) {

        // simulate slow processing (AI / external call)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        String answer = "You asked (async): " + question;

        Conversation conversation = new Conversation(question, answer);

        repository.save(conversation);

        return CompletableFuture.completedFuture(answer);
    }
}
