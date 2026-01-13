Customer support systems often rely on external AI services, which can be:

Costly

Non-deterministic

Hard to debug

Overkill for common FAQs

This project solves the problem by implementing a knowledge-base–driven answer engine that:

Responds deterministically

Is fast and testable

Can later plug in AI engines using the same interface

🧠 Solution Overview

The application exposes REST APIs that:

Accept user questions

Search a stored knowledge base

Return the best available answer

Allow admins to manage questions and answers

The core logic is abstracted behind an AnswerEngine interface, making the system open for extension, closed for modification.

🏗️ Architecture
Controller
↓
Service
↓
AnswerEngine (interface)
↓
KnowledgeBaseAnswerEngine
↓
Repository (JPA)
↓
H2 Database

Key Design Decisions

Interface-driven design for answer engines

DTO separation for request/response models

Service layer kept thin for testability

No async or transactions for deterministic reads

Clean refactor away from external AI dependencies

🛠️ Tech Stack

Java 17

Spring Boot 3.x

Spring Web

Spring Data JPA

H2 In-Memory Database

Maven

📂 Project Structure
backend
└── src/main/java/com/devanshi/aiagent/backend
├── controller
│ ├── AskController.java
│ ├── AdminKnowledgeController.java
│ └── HealthController.java
├── dto
│ ├── AskRequest.java
│ ├── AskResponse.java
│ └── KnowledgeRequest.java
├── engine
│ ├── AnswerEngine.java
│ └── impl/KnowledgeBaseAnswerEngine.java
├── entity
│ └── KnowledgeBase.java
├── repository
│ └── KnowledgeBaseRepository.java
├── service
│ ├── AskService.java
│ └── AskServiceImpl.java
└── BackendApplication.java

🚀 Running the Application
Prerequisites

Java 17+

Maven

Start the application
./mvnw clean spring-boot:run

The server runs on:

http://localhost:8080

🔍 API Endpoints
1️⃣ Ask a Question

POST /api/ask

{
"question": "What is constructor injection?"
}

Response

{
"answer": "Constructor injection is a dependency injection technique..."
}

If the answer is not found:

{
"answer": "I don't have an answer yet. An admin can add this."
}

2️⃣ Add Knowledge (Admin)

POST /api/admin/knowledge

{
"question": "What is constructor injection?",
"answer": "Constructor injection is a recommended dependency injection approach in Spring."
}

3️⃣ Health Check

GET /health

{
"status": "UP"
}

🗄️ Database

Uses H2 in-memory database

Console available at:

http://localhost:8080/h2-console

JDBC URL:

jdbc:h2:mem:testdb

🧪 Testing with curl
curl -X POST http://localhost:8080/api/ask \
 -H "Content-Type: application/json" \
 -d '{"question":"constructor"}'

🔮 Future Enhancements

Partial / fuzzy matching with ranking

Pagination & sorting for admin APIs

Authentication for admin endpoints

Plug-in AI engines (OpenAI, Groq, etc.) via AnswerEngine

Persistent database (PostgreSQL)

🎯 Why This Project Matters

This project demonstrates:

Clean backend architecture

Thoughtful refactoring decisions

Interface-based extensibility

Real-world API design

Production-style commit discipline

It is intentionally simple, deterministic, and explainable — exactly what many product companies value.

👤 Author

Devanshi Garg
Backend Engineer | Java | Spring Boot
