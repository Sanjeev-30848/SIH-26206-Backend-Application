package com.klef.sih.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.klef.sih.dto.EmergencyRequest;
import com.klef.sih.dto.EmergencyResponse;
import com.klef.sih.entity.Emergency;
import com.klef.sih.entity.EmergencyStatus;
import com.klef.sih.exception.EmergencyNotFoundException;
import com.klef.sih.repository.EmergencyRepository;

@Service
public class EmergencyServiceImpl implements EmergencyService 
{
    private final EmergencyRepository emergencyRepository;

    public EmergencyServiceImpl(
            EmergencyRepository emergencyRepository) {

        this.emergencyRepository = emergencyRepository;
    }

    @Override
    public EmergencyResponse createEmergency(
            EmergencyRequest request) {

        Emergency emergency = new Emergency();

        emergency.setUserId(request.getUserId());
        emergency.setUserName(request.getUserName());
        emergency.setType(request.getType());
        emergency.setDescription(request.getDescription());
        emergency.setLocation(request.getLocation());
        emergency.setContactNumber(request.getContactNumber());
        emergency.setAssignedAuthority(
                request.getAssignedAuthority());

        Emergency saved = emergencyRepository.save(emergency);

        return convertToResponse(saved);
    }

    @Override
    public EmergencyResponse getEmergencyById(Long id) {

        Emergency emergency = emergencyRepository.findById(id)
                .orElseThrow(() ->
                    new EmergencyNotFoundException(
                        "Emergency not found with ID: " + id));

        return convertToResponse(emergency);
    }

    @Override
    public List<EmergencyResponse> getAllEmergencies() {

        return emergencyRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmergencyResponse> getEmergenciesByUser(
            Long userId) {

        return emergencyRepository.findByUserId(userId)
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmergencyResponse> getEmergenciesByStatus(
            EmergencyStatus status) {

        return emergencyRepository.findByStatus(status)
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EmergencyResponse updateEmergency(
            Long id,
            EmergencyRequest request) {

        Emergency emergency = emergencyRepository.findById(id)
                .orElseThrow(() ->
                    new EmergencyNotFoundException(
                        "Emergency not found with ID: " + id));

        emergency.setUserId(request.getUserId());
        emergency.setUserName(request.getUserName());
        emergency.setType(request.getType());
        emergency.setDescription(request.getDescription());
        emergency.setLocation(request.getLocation());
        emergency.setContactNumber(request.getContactNumber());
        emergency.setAssignedAuthority(
                request.getAssignedAuthority());

        Emergency updated =
                emergencyRepository.save(emergency);

        return convertToResponse(updated);
    }

    @Override
    public void deleteEmergency(Long id) {

        if (!emergencyRepository.existsById(id)) {

            throw new EmergencyNotFoundException(
                    "Emergency not found with ID: " + id);
        }

        emergencyRepository.deleteById(id);
    }

    private EmergencyResponse convertToResponse(
            Emergency emergency) {

        return new EmergencyResponse(
                emergency.getId(),
                emergency.getUserId(),
                emergency.getUserName(),
                emergency.getType(),
                emergency.getDescription(),
                emergency.getLocation(),
                emergency.getContactNumber(),
                emergency.getStatus(),
                emergency.getAssignedAuthority(),
                emergency.getCreatedAt(),
                emergency.getUpdatedAt()
        );
    }
}