package com.klef.sih.dto;

import com.klef.sih.entity.EmergencyType;

public class EmergencyRequest 
{

    private Long userId;

    private String userName;

    private EmergencyType type;

    private String description;

    private String location;

    private String contactNumber;

    private String assignedAuthority;

    public EmergencyRequest() {
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

    public String getAssignedAuthority() {
        return assignedAuthority;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setType(EmergencyType type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setAssignedAuthority(String assignedAuthority) {
        this.assignedAuthority = assignedAuthority;
    }
}