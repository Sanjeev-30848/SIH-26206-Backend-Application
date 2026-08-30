package com.klef.sih.dto;

import com.klef.sih.entity.ShelterType;

public class ShelterRequest 
{

    private String name;

    private String address;

    private String location;

    private Integer capacity;

    private Integer availableSpaces;

    private ShelterType type;

    private String contactNumber;

    private Boolean active;

    public ShelterRequest() {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setAvailableSpaces(Integer availableSpaces) {
        this.availableSpaces = availableSpaces;
    }

    public void setType(ShelterType type) {
        this.type = type;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}