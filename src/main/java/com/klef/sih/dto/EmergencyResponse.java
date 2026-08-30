package com.klef.sih.dto;

import java.time.LocalDateTime;

import com.klef.sih.entity.EmergencyStatus;
import com.klef.sih.entity.EmergencyType;

public class EmergencyResponse {

    private Long id;

    private Long userId;

    private String userName;

    private EmergencyType type;

    private String description;

    private String location;

    private String contactNumber;

    private EmergencyStatus status;

    private String assignedAuthority;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public EmergencyResponse() {
    }

    public EmergencyResponse(
            Long id,
            Long userId,
            String userName,
            EmergencyType type,
            String description,
            String location,
            String contactNumber,
            EmergencyStatus status,
            String assignedAuthority,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {

        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.type = type;
        this.description = description;
        this.location = location;
        this.contactNumber = contactNumber;
        this.status = status;
        this.assignedAuthority = assignedAuthority;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public EmergencyType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public EmergencyStatus getStatus() {
        return status;
    }

    public String getAssignedAuthority() {
        return assignedAuthority;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}