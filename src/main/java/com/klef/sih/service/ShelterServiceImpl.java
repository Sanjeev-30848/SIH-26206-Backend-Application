package com.klef.sih.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.klef.sih.dto.ShelterRequest;
import com.klef.sih.dto.ShelterResponse;
import com.klef.sih.entity.Shelter;
import com.klef.sih.entity.ShelterType;
import com.klef.sih.exception.ShelterNotFoundException;
import com.klef.sih.repository.ShelterRepository;

@Service
public class ShelterServiceImpl implements ShelterService 
{

    private final ShelterRepository shelterRepository;

    public ShelterServiceImpl(ShelterRepository shelterRepository) {
        this.shelterRepository = shelterRepository;
    }

    @Override
    public ShelterResponse createShelter(ShelterRequest request) {

        Shelter shelter = new Shelter();

        shelter.setName(request.getName());
        shelter.setAddress(request.getAddress());
        shelter.setLocation(request.getLocation());
        shelter.setCapacity(request.getCapacity());
        shelter.setAvailableSpaces(request.getAvailableSpaces());
        shelter.setType(request.getType());
        shelter.setContactNumber(request.getContactNumber());
        shelter.setActive(request.getActive());

        Shelter savedShelter = shelterRepository.save(shelter);

        return convertToResponse(savedShelter);
    }

    @Override
    public ShelterResponse getShelterById(Long id) {

        Shelter shelter = shelterRepository.findById(id)
                .orElseThrow(() ->
                        new ShelterNotFoundException(
                                "Shelter not found with ID: " + id));

        return convertToResponse(shelter);
    }

    @Override
    public List<ShelterResponse> getAllShelters() {

        return shelterRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ShelterResponse> getActiveShelters() {

        return shelterRepository.findByActiveTrue()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ShelterResponse> getSheltersByLocation(
            String location) {

        return shelterRepository
                .findByLocationIgnoreCaseAndActiveTrue(location)
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ShelterResponse> getSheltersByType(
            ShelterType type) {

        return shelterRepository.findByType(type)
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ShelterResponse updateShelter(
            Long id,
            ShelterRequest request) {

        Shelter shelter = shelterRepository.findById(id)
                .orElseThrow(() ->
                        new ShelterNotFoundException(
                                "Shelter not found with ID: " + id));

        shelter.setName(request.getName());
        shelter.setAddress(request.getAddress());
        shelter.setLocation(request.getLocation());
        shelter.setCapacity(request.getCapacity());
        shelter.setAvailableSpaces(request.getAvailableSpaces());
        shelter.setType(request.getType());
        shelter.setContactNumber(request.getContactNumber());
        shelter.setActive(request.getActive());

        Shelter updatedShelter =
                shelterRepository.save(shelter);

        return convertToResponse(updatedShelter);
    }

    @Override
    public void deleteShelter(Long id) {

        if (!shelterRepository.existsById(id)) {

            throw new ShelterNotFoundException(
                    "Shelter not found with ID: " + id);
        }

        shelterRepository.deleteById(id);
    }

    private ShelterResponse convertToResponse(
            Shelter shelter) {

        return new ShelterResponse(
                shelter.getId(),
                shelter.getName(),
                shelter.getAddress(),
                shelter.getLocation(),
                shelter.getCapacity(),
                shelter.getAvailableSpaces(),
                shelter.getType(),
                shelter.getContactNumber(),
                shelter.getActive(),
                shelter.getCreatedAt(),
                shelter.getUpdatedAt()
        );
    }
}