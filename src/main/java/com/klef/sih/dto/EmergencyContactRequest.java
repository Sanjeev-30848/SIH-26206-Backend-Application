package com.klef.sih.dto;

import com.klef.sih.entity.EmergencyContactType;

public class EmergencyContactRequest 
{

    private String name;

    private String phoneNumber;

    private String email;

    private String department;

    private String location;

    private EmergencyContactType type;

    private Boolean active;

    public EmergencyContactRequest() {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setType(EmergencyContactType type) {
        this.type = type;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}