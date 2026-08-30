package com.klef.sih.service;

import java.util.List;

import com.klef.sih.dto.AlertRequest;
import com.klef.sih.dto.AlertResponse;
import com.klef.sih.entity.AlertSeverity;
import com.klef.sih.entity.AlertType;

public interface AlertService {

    AlertResponse createAlert(AlertRequest request);

    AlertResponse getAlertById(Long id);

    List<AlertResponse> getAllAlerts();

    List<AlertResponse> getAlertsByType(AlertType type);

    List<AlertResponse> getAlertsBySeverity(AlertSeverity severity);

    List<AlertResponse> getAlertsByLocation(String location);

    AlertResponse updateAlert(Long id, AlertRequest request);

    void deleteAlert(Long id);
}