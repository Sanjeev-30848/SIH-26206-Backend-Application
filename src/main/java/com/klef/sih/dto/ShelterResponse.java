package com.klef.sih.dto;

import java.time.LocalDateTime;

import com.klef.sih.entity.ShelterType;

public class ShelterResponse 
{

    private Long id;

    private String name;

    private String address;

    private String location;

    private Integer capacity;

    private Integer availableSpaces;

    private ShelterType type;

    private String contactNumber;

    private Boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public ShelterResponse() {
    }

    public ShelterResponse(
            Long id,
            String name,
            String address,
            String location,
            Integer capacity,
            Integer availableSpaces,
            ShelterType type,
            String contactNumber,
            Boolean active,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {

        this.id = id;
        this.name = name;
        this.address = address;
        this.location = location;
        this.capacity = capacity;
        this.availableSpaces = availableSpaces;
        this.type = type;
        this.contactNumber = contactNumber;
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

    public String getAddress() {
        return address;
    }

    public String getLocation() {
        return location;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Integer getAvailableSpaces() {
        return availableSpaces;
    }

    public ShelterType getType() {
        return type;
    }

    public String getContactNumber() {
        return contactNumber;
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