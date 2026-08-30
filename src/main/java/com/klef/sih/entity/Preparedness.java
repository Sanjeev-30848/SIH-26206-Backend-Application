package com.klef.sih.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "preparedness")
public class Preparedness 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String disasterType;

    @Enumerated(EnumType.STRING)
    private PreparednessType type;

    private Integer priority;

    private Boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Preparedness() {
    }

    @PrePersist
    protected void onCreate() 
    {
        LocalDateTime now = LocalDateTime.now();
        createdAt = now;
        updatedAt = now;

        if (active == null) 
        {
            active = true;
        }

        if (priority == null)
        {
            priority = 1;
        }
    }

    @PreUpdate
    protected void onUpdate() 
    {
        updatedAt = LocalDateTime.now();
    }

    public Long getId() 
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public String getDescription() 
    {
        return description;
    }

    public String getDisasterType()
    {
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

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public void setDisasterType(String disasterType)
    {
        this.disasterType = disasterType;
    }

    public void setType(PreparednessType type) 
    {
        this.type = type;
    }

    public void setPriority(Integer priority) 
    {
        this.priority = priority;
    }

    public void setActive(Boolean active) 
    {
        this.active = active;
    }
}