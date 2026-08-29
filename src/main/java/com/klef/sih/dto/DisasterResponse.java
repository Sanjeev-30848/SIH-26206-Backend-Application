package com.klef.sih.dto;

import java.time.LocalDateTime;

import com.klef.sih.entity.DisasterType;

public class DisasterResponse 
{

    private Long id;

    private String name;

    private DisasterType type;

    private String description;

    private String location;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public DisasterResponse(){
    }

    public DisasterResponse(
            Long id,
            String name,
            DisasterType type,
            String description,
            String location,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {

        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.location = location;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public DisasterType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setType(DisasterType type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}