package com.klef.sih.service;

import java.util.List;

import com.klef.sih.dto.EmergencyContactRequest;
import com.klef.sih.dto.EmergencyContactResponse;
import com.klef.sih.entity.EmergencyContactType;

public interface EmergencyContactService 
{

    EmergencyContactResponse createContact(
            EmergencyContactRequest request);

    EmergencyContactResponse getContactById(Long id);

    List<EmergencyContactResponse> getAllContacts();

    List<EmergencyContactResponse> getActiveContacts();

    List<EmergencyContactResponse> getContactsByType(
            EmergencyContactType type);

    List<EmergencyContactResponse> getContactsByLocation(
            String location);

    EmergencyContactResponse updateContact(
            Long id,
            EmergencyContactRequest request);

    void deleteContact(Long id);
}