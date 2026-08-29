package com.klef.sih.dto;

import com.klef.sih.entity.DisasterType;

public class DisasterRequest 
{

    private String name;

    private DisasterType type;

    private String description;

    private String location;

    public DisasterRequest() {
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
}