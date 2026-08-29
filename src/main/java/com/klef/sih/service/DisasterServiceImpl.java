package com.klef.sih.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.klef.sih.dto.DisasterRequest;
import com.klef.sih.dto.DisasterResponse;
import com.klef.sih.entity.Disaster;
import com.klef.sih.entity.DisasterType;
import com.klef.sih.exception.DisasterNotFoundException;
import com.klef.sih.repository.DisasterRepository;

@Service
public class DisasterServiceImpl implements DisasterService 
{

    private final DisasterRepository disasterRepository;

    public DisasterServiceImpl(
            DisasterRepository disasterRepository) {

        this.disasterRepository = disasterRepository;
    }

    @Override
    public DisasterResponse createDisaster(
            DisasterRequest request) {

        Disaster disaster = new Disaster();

        disaster.setName(request.getName());
        disaster.setType(request.getType());
        disaster.setDescription(request.getDescription());
        disaster.setLocation(request.getLocation());

        Disaster savedDisaster =
                disasterRepository.save(disaster);

        return convertToResponse(savedDisaster);
    }

    @Override
    public DisasterResponse getDisasterById(Long id) {

        Disaster disaster =
                disasterRepository.findById(id)
                        .orElseThrow(() ->
                                new DisasterNotFoundException(
                                        "Disaster not found with ID: "
                                        + id));

        return convertToResponse(disaster);
    }

    @Override
    public List<DisasterResponse> getAllDisasters() {

        return disasterRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<DisasterResponse> getDisastersByType(
            DisasterType type) {

        return disasterRepository.findByType(type)
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DisasterResponse updateDisaster(
            Long id,
            DisasterRequest request) {

        Disaster disaster =
                disasterRepository.findById(id)
                        .orElseThrow(() ->
                                new DisasterNotFoundException(
                                        "Disaster not found with ID: "
                                        + id));

        disaster.setName(request.getName());
        disaster.setType(request.getType());
        disaster.setDescription(request.getDescription());
        disaster.setLocation(request.getLocation());

        Disaster updatedDisaster =
                disasterRepository.save(disaster);

        return convertToResponse(updatedDisaster);
    }

    @Override
    public void deleteDisaster(Long id) {

        if (!disasterRepository.existsById(id)) {

            throw new DisasterNotFoundException(
                    "Disaster not found with ID: " + id);
        }

        disasterRepository.deleteById(id);
    }

    private DisasterResponse convertToResponse(
            Disaster disaster) {

        return new DisasterResponse(
                disaster.getId(),
                disaster.getName(),
                disaster.getType(),
                disaster.getDescription(),
                disaster.getLocation(),
                disaster.getCreatedAt(),
                disaster.getUpdatedAt()
        );
    }
}