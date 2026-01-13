package com.devanshi.aiagent.backend.controller;

import com.devanshi.aiagent.backend.dto.KnowledgeRequest;
import com.devanshi.aiagent.backend.entity.KnowledgeBase;
import com.devanshi.aiagent.backend.repository.KnowledgeBaseRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/knowledge")
public class AdminKnowledgeController {

    private final KnowledgeBaseRepository repository;

    public AdminKnowledgeController(KnowledgeBaseRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public String addKnowledge(@RequestBody @Valid KnowledgeRequest request) {

        repository.save(
                new KnowledgeBase(
                        request.getQuestion(),
                        request.getAnswer()));

        return "Knowledge added successfully";
    }
}
