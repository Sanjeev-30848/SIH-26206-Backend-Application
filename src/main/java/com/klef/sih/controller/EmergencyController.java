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

import com.klef.sih.dto.EmergencyRequest;
import com.klef.sih.dto.EmergencyResponse;
import com.klef.sih.entity.EmergencyStatus;
import com.klef.sih.service.EmergencyService;

@RestController
@RequestMapping("/api/emergencies")
@CrossOrigin
public class EmergencyController 
{

    private final EmergencyService emergencyService;

    public EmergencyController(
            EmergencyService emergencyService) {

        this.emergencyService = emergencyService;
    }

    @PostMapping
    public ResponseEntity<EmergencyResponse> createEmergency(
            @RequestBody EmergencyRequest request) {

        return new ResponseEntity<>(
                emergencyService.createEmergency(request),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<EmergencyResponse>>
            getAllEmergencies() {

        return ResponseEntity.ok(
                emergencyService.getAllEmergencies()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmergencyResponse>
            getEmergencyById(@PathVariable Long id) {

        return ResponseEntity.ok(
                emergencyService.getEmergencyById(id)
        );
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<EmergencyResponse>>
            getEmergenciesByUser(
                    @PathVariable Long userId) {

        return ResponseEntity.ok(
                emergencyService.getEmergenciesByUser(userId)
        );
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<EmergencyResponse>>
            getEmergenciesByStatus(
                    @PathVariable EmergencyStatus status) {

        return ResponseEntity.ok(
                emergencyService.getEmergenciesByStatus(status)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmergencyResponse>
            updateEmergency(
                    @PathVariable Long id,
                    @RequestBody EmergencyRequest request) {

        return ResponseEntity.ok(
                emergencyService.updateEmergency(
                        id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmergency(
            @PathVariable Long id) {

        emergencyService.deleteEmergency(id);

        return ResponseEntity.ok(
                "Emergency deleted successfully"
        );
    }
}