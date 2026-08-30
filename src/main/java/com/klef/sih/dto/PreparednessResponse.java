package com.klef.sih.dto;

import java.time.LocalDateTime;

import com.klef.sih.entity.PreparednessType;

public class PreparednessResponse {

    private Long id;

    private String title;

    private String description;

    private String disasterType;

    private PreparednessType type;

    private Integer priority;

    private Boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public PreparednessResponse() {
    }
    

    public PreparednessResponse(
            Long id,
            String title,
            String description,
            String disasterType,
            PreparednessType type,
            Integer priority,
            Boolean active,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.disasterType = disasterType;
        this.type = type;
        this.priority = priority;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDisasterType() {
        return disasterType;
    }

    public PreparednessType getType() 
    {
        return type;
    }

    public Integer getPriority() 
    {
        return priority;
    }

    public Boolean getActive() 
    {
        return active;
    }

    public LocalDateTime getCreatedAt()
    {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() 
    {
        return updatedAt;
    }
}