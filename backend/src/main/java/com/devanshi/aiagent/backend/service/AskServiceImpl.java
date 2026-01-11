package com.devanshi.aiagent.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.devanshi.aiagent.backend.dto.ConversationResponse;
import com.devanshi.aiagent.backend.entity.Conversation;
import com.devanshi.aiagent.backend.repository.ConversationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AskServiceImpl implements AskService {

    private final ConversationRepository repository;

    public AskServiceImpl(ConversationRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public String processQuestion(String question) {

        String answer = "You asked: " + question;

        Conversation conversation = new Conversation(question, answer);

        repository.save(conversation);

        return answer;
    }

    @Override
    public Page<ConversationResponse> getConversationHistory(Pageable pageable) {

        return repository.findAll(pageable)
                .map(c -> new ConversationResponse(
                        c.getId(),
                        c.getQuestion(),
                        c.getAnswer(),
                        c.getCreatedAt()));
    }
}
