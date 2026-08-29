package com.klef.sih.service;

import java.util.List;

import com.klef.sih.dto.SOSRequestDTO;
import com.klef.sih.dto.SOSResponse;
import com.klef.sih.entity.SOSStatus;

public interface SOSService 
{

    SOSResponse createSOS(String email, SOSRequestDTO request);

    SOSResponse getSOSById(Long id);

    List<SOSResponse> getAllSOS();

    List<SOSResponse> getSOSByUser(Long userId);

    List<SOSResponse> getSOSByStatus(SOSStatus status);

    SOSResponse updateSOSStatus(Long id, SOSStatus status);

    void deleteSOS(Long id);
}