package com.klef.sih.dto;

import java.time.LocalDateTime;

import com.klef.sih.entity.AlertSeverity;
import com.klef.sih.entity.AlertType;

public class AlertRequest 
{

    private String title;

    private String message;

    private AlertType type;

    private AlertSeverity severity;

    private String location;

    private LocalDateTime expiresAt;

    public AlertRequest() {
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
}