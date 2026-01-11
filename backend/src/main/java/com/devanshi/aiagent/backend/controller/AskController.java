package com.devanshi.aiagent.backend.controller;

import com.devanshi.aiagent.backend.dto.AskRequest;
import com.devanshi.aiagent.backend.dto.AskResponse;
import com.devanshi.aiagent.backend.dto.ConversationResponse;
import com.devanshi.aiagent.backend.service.AskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ask")
public class AskController {

    private final AskService askService;

    public AskController(AskService askService) {
        this.askService = askService;
    }

    @PostMapping
    public AskResponse ask(@Valid @RequestBody AskRequest request) {
        String answer = askService.processQuestion(request.getQuestion());
        return new AskResponse(answer);
    }

    @GetMapping("/history")
    public List<ConversationResponse> history() {
        return askService.getConversationHistory();
    }

}
