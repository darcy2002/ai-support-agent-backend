package com.devanshi.aiagent.backend.service;

import java.util.concurrent.CompletableFuture;

public interface AskService {

    String processQuestion(String question);

    CompletableFuture<String> processQuestionAsync(String question);

}
