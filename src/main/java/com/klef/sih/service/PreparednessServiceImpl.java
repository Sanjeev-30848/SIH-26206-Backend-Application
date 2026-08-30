package com.klef.sih.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.klef.sih.dto.PreparednessRequest;
import com.klef.sih.dto.PreparednessResponse;
import com.klef.sih.entity.Preparedness;
import com.klef.sih.entity.PreparednessType;
import com.klef.sih.exception.PreparednessNotFoundException;
import com.klef.sih.repository.PreparednessRepository;

@Service
public class PreparednessServiceImpl
        implements PreparednessService 
        {

    private final PreparednessRepository preparednessRepository;

    public PreparednessServiceImpl(
            PreparednessRepository preparednessRepository) {

        this.preparednessRepository = preparednessRepository;
    }

    @Override
    public PreparednessResponse createPreparedness(
            PreparednessRequest request) {

        Preparedness preparedness = new Preparedness();

        preparedness.setTitle(request.getTitle());
        preparedness.setDescription(request.getDescription());
        preparedness.setDisasterType(request.getDisasterType());
        preparedness.setType(request.getType());
        preparedness.setPriority(request.getPriority());
        preparedness.setActive(request.getActive());

        Preparedness saved =
                preparednessRepository.save(preparedness);

        return convertToResponse(saved);
    }

    @Override
    public PreparednessResponse getPreparednessById(Long id) {

        Preparedness preparedness =
                preparednessRepository.findById(id)
                .orElseThrow(() ->
                    new PreparednessNotFoundException(
                        "Preparedness not found with ID: " + id));

        return convertToResponse(preparedness);
    }

    @Override
    public List<PreparednessResponse> getAllPreparedness() {

        return preparednessRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<PreparednessResponse> getActivePreparedness() {

        return preparednessRepository.findByActiveTrue()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<PreparednessResponse> getByType(
            PreparednessType type) {

        return preparednessRepository.findByType(type)
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<PreparednessResponse> getByDisasterType(
            String disasterType) {

        return preparednessRepository
                .findByDisasterTypeIgnoreCaseAndActiveTrue(
                        disasterType)
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PreparednessResponse updatePreparedness(
            Long id,
            PreparednessRequest request) {

        Preparedness preparedness =
                preparednessRepository.findById(id)
                .orElseThrow(() ->
                    new PreparednessNotFoundException(
                        "Preparedness not found with ID: " + id));

        preparedness.setTitle(request.getTitle());
        preparedness.setDescription(request.getDescription());
        preparedness.setDisasterType(request.getDisasterType());
        preparedness.setType(request.getType());
        preparedness.setPriority(request.getPriority());
        preparedness.setActive(request.getActive());

        Preparedness updated =
                preparednessRepository.save(preparedness);

        return convertToResponse(updated);
    }

    @Override
    public void deletePreparedness(Long id) {

        if (!preparednessRepository.existsById(id)) {

            throw new PreparednessNotFoundException(
                    "Preparedness not found with ID: " + id);
        }

        preparednessRepository.deleteById(id);
    }

    private PreparednessResponse convertToResponse(
            Preparedness preparedness) {

        return new PreparednessResponse(
                preparedness.getId(),
                preparedness.getTitle(),
                preparedness.getDescription(),
                preparedness.getDisasterType(),
                preparedness.getType(),
                preparedness.getPriority(),
                preparedness.getActive(),
                preparedness.getCreatedAt(),
                preparedness.getUpdatedAt()
        );
    }
}