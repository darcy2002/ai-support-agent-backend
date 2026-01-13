package com.devanshi.aiagent.backend.config;

import com.devanshi.aiagent.backend.entity.KnowledgeBase;
import com.devanshi.aiagent.backend.repository.KnowledgeBaseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(KnowledgeBaseRepository repository) {
        return args -> {
            if (repository.count() == 0) {

                repository.save(new KnowledgeBase(
                        "What is Spring Boot?",
                        "Spring Boot simplifies Spring development by providing auto-configuration and embedded servers."));

                repository.save(new KnowledgeBase(
                        "What is constructor injection?",
                        "Constructor injection provides dependencies through a class constructor and is recommended for immutability and testability."));

                repository.save(new KnowledgeBase(
                        "What is REST?",
                        "REST is an architectural style that uses stateless HTTP communication and standard methods."));

                // add more as needed
            }
        };
    }
}
