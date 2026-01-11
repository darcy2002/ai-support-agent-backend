package com.devanshi.aiagent.backend.service;

import com.devanshi.aiagent.backend.entity.Conversation;
import java.util.List;

public interface AskService {

    String processQuestion(String question);

    List<Conversation> getAllConversations();
}
