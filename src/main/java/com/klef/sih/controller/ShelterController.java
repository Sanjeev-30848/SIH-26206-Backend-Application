package com.klef.sih.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.sih.dto.ShelterRequest;
import com.klef.sih.dto.ShelterResponse;
import com.klef.sih.entity.ShelterType;
import com.klef.sih.service.ShelterService;

@RestController
@RequestMapping("/api/shelters")
@CrossOrigin
public class ShelterController
{

    private final ShelterService shelterService;

    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    @PostMapping
    public ResponseEntity<ShelterResponse> createShelter(
            @RequestBody ShelterRequest request) {

        return new ResponseEntity<>(
                shelterService.createShelter(request),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<ShelterResponse>> getAllShelters() {

        return ResponseEntity.ok(
                shelterService.getAllShelters()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShelterResponse> getShelterById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                shelterService.getShelterById(id)
        );
    }

    @GetMapping("/active")
    public ResponseEntity<List<ShelterResponse>> getActiveShelters() {

        return ResponseEntity.ok(
                shelterService.getActiveShelters()
        );
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<ShelterResponse>> getSheltersByLocation(
            @PathVariable String location) {

        return ResponseEntity.ok(
                shelterService.getSheltersByLocation(location)
        );
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<ShelterResponse>> getSheltersByType(
            @PathVariable ShelterType type) {

        return ResponseEntity.ok(
                shelterService.getSheltersByType(type)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShelterResponse> updateShelter(
            @PathVariable Long id,
            @RequestBody ShelterRequest request) {

        return ResponseEntity.ok(
                shelterService.updateShelter(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShelter(
            @PathVariable Long id) {

        shelterService.deleteShelter(id);

        return ResponseEntity.ok(
                "Shelter deleted successfully"
        );
    }
}