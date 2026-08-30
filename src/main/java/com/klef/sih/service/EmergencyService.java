package com.klef.sih.service;

import java.util.List;

import com.klef.sih.dto.EmergencyRequest;
import com.klef.sih.dto.EmergencyResponse;
import com.klef.sih.entity.EmergencyStatus;

public interface EmergencyService 
{

    EmergencyResponse createEmergency(EmergencyRequest request);

    EmergencyResponse getEmergencyById(Long id);

    List<EmergencyResponse> getAllEmergencies();

    List<EmergencyResponse> getEmergenciesByUser(Long userId);

    List<EmergencyResponse> getEmergenciesByStatus(
            EmergencyStatus status);

    EmergencyResponse updateEmergency(
            Long id,
            EmergencyRequest request);

    void deleteEmergency(Long id);
}