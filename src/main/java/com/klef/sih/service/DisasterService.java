package com.klef.sih.service;

import java.util.List;

import com.klef.sih.dto.DisasterRequest;
import com.klef.sih.dto.DisasterResponse;
import com.klef.sih.entity.DisasterType;

public interface DisasterService 
{

    DisasterResponse createDisaster(DisasterRequest request);

    DisasterResponse getDisasterById(Long id);

    List<DisasterResponse> getAllDisasters();

    List<DisasterResponse> getDisastersByType(
            DisasterType type);

    DisasterResponse updateDisaster(
            Long id,
            DisasterRequest request);

    void deleteDisaster(Long id);
}