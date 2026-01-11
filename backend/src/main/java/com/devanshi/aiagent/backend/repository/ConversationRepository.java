package com.devanshi.aiagent.backend.repository;

import com.devanshi.aiagent.backend.entity.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationRepository
        extends JpaRepository<Conversation, Long> {
}
