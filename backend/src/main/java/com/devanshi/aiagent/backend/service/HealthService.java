package com.devanshi.aiagent.backend.service;

import org.springframework.stereotype.Service;

@Service
public class HealthService {

    public String getHealthStatus() {
        return "Application is running";
    }
}
