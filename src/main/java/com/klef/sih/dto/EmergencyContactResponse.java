package com.klef.sih.dto;

import java.time.LocalDateTime;

import com.klef.sih.entity.EmergencyContactType;

public class EmergencyContactResponse
{

    private Long id;

    private String name;

    private String phoneNumber;

    private String email;

    private String department;

    private String location;

    private EmergencyContactType type;

    private Boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public EmergencyContactResponse() {
    }

    public EmergencyContactResponse(
            Long id,
            String name,
            String phoneNumber,
            String email,
            String department,
            String location,
            EmergencyContactType type,
            Boolean active,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {

        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.department = department;
        this.location = location;
        this.type = type;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public String getLocation() {
        return location;
    }

    public EmergencyContactType getType() {
        return type;
    }

    public Boolean getActive() {
        return active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}