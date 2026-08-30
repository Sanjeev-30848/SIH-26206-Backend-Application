package com.klef.sih.dto;

import com.klef.sih.entity.PreparednessType;

public class PreparednessRequest 
{

    private String title;

    private String description;

    private String disasterType;

    private PreparednessType type;

    private Integer priority;

    private Boolean active;

    public PreparednessRequest()
    {
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