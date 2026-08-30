package com.klef.sih.dto;

import java.time.LocalDateTime;

import com.klef.sih.entity.AlertSeverity;
import com.klef.sih.entity.AlertType;

public class AlertResponse
{

    private Long id;

    private String title;

    private String message;

    private AlertType type;

    private AlertSeverity severity;

    private String location;

    private LocalDateTime expiresAt;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public AlertResponse() {
    }

    public AlertResponse(
            Long id,
            String title,
            String message,
            AlertType type,
            AlertSeverity severity,
            String location,
            LocalDateTime expiresAt,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {

        this.id = id;
        this.title = title;
        this.message = message;
        this.type = type;
        this.severity = severity;
        this.location = location;
        this.expiresAt = expiresAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public AlertType getType() {
        return type;
    }

    public AlertSeverity getSeverity() {
        return severity;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setType(AlertType type) {
        this.type = type;
    }

    public void setSeverity(AlertSeverity severity) {
        this.severity = severity;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}