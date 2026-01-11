package com.devanshi.aiagent.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleValidation(
            MethodArgumentNotValidException ex) {

        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();

        ApiErrorResponse error = new ApiErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                errorMessage);

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGeneric(Exception ex) {
        // #region agent log
        try {
            String logEntry = String.format(
                    "{\"id\":\"log_%d_%s\",\"timestamp\":%d,\"location\":\"GlobalExceptionHandler.java:32\",\"message\":\"Exception caught\",\"data\":{\"exception\":\"%s\",\"message\":\"%s\",\"stackTrace\":\"%s\"},\"sessionId\":\"debug-session\",\"runId\":\"run1\",\"hypothesisId\":\"C\"}\n",
                    System.currentTimeMillis(), "exception_caught", System.currentTimeMillis(),
                    ex.getClass().getName(),
                    ex.getMessage() != null ? ex.getMessage().replace("\"", "'").replace("\n", " ") : "null",
                    getStackTraceString(ex));
            Files.write(Paths.get("/Users/devanshigarg/Documents/GitHub/ai-support-agent-backend/.cursor/debug.log"),
                    logEntry.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (Exception logEx) {
        }
        // #endregion

        ApiErrorResponse error = new ApiErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Something went wrong");

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String getStackTraceString(Exception ex) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement element : ex.getStackTrace()) {
            if (sb.length() > 500)
                break; // Limit size
            sb.append(element.toString()).append("; ");
        }
        return sb.toString().replace("\"", "'").replace("\n", " ");
    }
}
