package com.klef.sih.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.klef.sih.dto.AlertRequest;
import com.klef.sih.dto.AlertResponse;
import com.klef.sih.entity.Alert;
import com.klef.sih.entity.AlertSeverity;
import com.klef.sih.entity.AlertType;
import com.klef.sih.exception.AlertNotFoundException;
import com.klef.sih.repository.AlertRepository;

@Service
public class AlertServiceImpl implements AlertService {

    private final AlertRepository alertRepository;

    public AlertServiceImpl(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    @Override
    public AlertResponse createAlert(AlertRequest request) {

        Alert alert = new Alert();

        alert.setTitle(request.getTitle());
        alert.setMessage(request.getMessage());
        alert.setType(request.getType());
        alert.setSeverity(request.getSeverity());
        alert.setLocation(request.getLocation());
        alert.setExpiresAt(request.getExpiresAt());

        Alert savedAlert = alertRepository.save(alert);

        return convertToResponse(savedAlert);
    }

    @Override
    public AlertResponse getAlertById(Long id) {

        Alert alert = alertRepository.findById(id)
                .orElseThrow(() ->
                        new AlertNotFoundException(
                                "Alert not found with ID: " + id));

        return convertToResponse(alert);
    }

    @Override
    public List<AlertResponse> getAllAlerts() {

        return alertRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<AlertResponse> getAlertsByType(AlertType type) {

        return alertRepository.findByType(type)
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<AlertResponse> getAlertsBySeverity(
            AlertSeverity severity) {

        return alertRepository.findBySeverity(severity)
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<AlertResponse> getAlertsByLocation(
            String location) {

        return alertRepository
                .findByLocationIgnoreCase(location)
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AlertResponse updateAlert(
            Long id,
            AlertRequest request) {

        Alert alert = alertRepository.findById(id)
                .orElseThrow(() ->
                        new AlertNotFoundException(
                                "Alert not found with ID: " + id));

        alert.setTitle(request.getTitle());
        alert.setMessage(request.getMessage());
        alert.setType(request.getType());
        alert.setSeverity(request.getSeverity());
        alert.setLocation(request.getLocation());
        alert.setExpiresAt(request.getExpiresAt());

        Alert updatedAlert = alertRepository.save(alert);

        return convertToResponse(updatedAlert);
    }

    @Override
    public void deleteAlert(Long id) {

        if (!alertRepository.existsById(id)) {

            throw new AlertNotFoundException(
                    "Alert not found with ID: " + id);
        }

        alertRepository.deleteById(id);
    }

    private AlertResponse convertToResponse(Alert alert) 
    {

        return new AlertResponse(
                alert.getId(),
                alert.getTitle(),
                alert.getMessage(),
                alert.getType(),
                alert.getSeverity(),
                alert.getLocation(),
                alert.getExpiresAt(),
                alert.getCreatedAt(),
                alert.getUpdatedAt()
        );
    }
}