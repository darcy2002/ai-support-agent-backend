package com.devanshi.aiagent.backend.service;

import com.devanshi.aiagent.backend.dto.ConversationResponse;
import java.util.List;

public interface AskService {

    String processQuestion(String question);

    List<ConversationResponse> getConversationHistory();
}
