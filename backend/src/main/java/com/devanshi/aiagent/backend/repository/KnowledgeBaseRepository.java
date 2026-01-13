package com.devanshi.aiagent.backend.repository;

import com.devanshi.aiagent.backend.entity.KnowledgeBase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KnowledgeBaseRepository extends JpaRepository<KnowledgeBase, Long> {

    Optional<KnowledgeBase> findFirstByQuestionContainingIgnoreCase(String question);
}
