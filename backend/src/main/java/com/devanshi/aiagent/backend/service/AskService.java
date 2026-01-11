package com.devanshi.aiagent.backend.service;

import com.devanshi.aiagent.backend.dto.ConversationResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AskService {

    String processQuestion(String question);

    Page<ConversationResponse> getConversationHistory(Pageable pageable);

}
