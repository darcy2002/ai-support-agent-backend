package com.devanshi.aiagent.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "conversations")
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String question;

    @Column(nullable = false)
    private String answer;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    protected Conversation() {
        // for JPA
    }

    public Conversation(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
