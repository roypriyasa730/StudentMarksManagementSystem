package com.example.springboot_app;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {
    private String message;
    private int status;
    private LocalDateTime timestamp;
    private String path;
    private List<String> errors;

    public ErrorResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public ErrorResponse(String message, int status, String path) {
        this();
        this.message = message;
        this.status = status;
        this.path = path;
    }

    public ErrorResponse(String message, int status, String path, List<String> errors) {
        this(message, status, path);
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
