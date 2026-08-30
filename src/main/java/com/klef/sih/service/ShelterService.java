package com.klef.sih.service;

import java.util.List;

import com.klef.sih.dto.ShelterRequest;
import com.klef.sih.dto.ShelterResponse;
import com.klef.sih.entity.ShelterType;

public interface ShelterService 
{

    ShelterResponse createShelter(ShelterRequest request);

    ShelterResponse getShelterById(Long id);

    List<ShelterResponse> getAllShelters();

    List<ShelterResponse> getActiveShelters();

    List<ShelterResponse> getSheltersByLocation(String location);

    List<ShelterResponse> getSheltersByType(ShelterType type);

    ShelterResponse updateShelter(Long id, ShelterRequest request);

    void deleteShelter(Long id);
}