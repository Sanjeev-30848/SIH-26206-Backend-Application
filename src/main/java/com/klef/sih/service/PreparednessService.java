package com.klef.sih.service;

import java.util.List;

import com.klef.sih.dto.PreparednessRequest;
import com.klef.sih.dto.PreparednessResponse;
import com.klef.sih.entity.PreparednessType;

public interface PreparednessService 
{

    PreparednessResponse createPreparedness(
            PreparednessRequest request);

    PreparednessResponse getPreparednessById(Long id);

    List<PreparednessResponse> getAllPreparedness();

    List<PreparednessResponse> getActivePreparedness();

    List<PreparednessResponse> getByType(
            PreparednessType type);

    List<PreparednessResponse> getByDisasterType(
            String disasterType);

    PreparednessResponse updatePreparedness(
            Long id,
            PreparednessRequest request);

    void deletePreparedness(Long id);
}