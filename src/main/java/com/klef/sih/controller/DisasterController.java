package com.klef.sih.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.sih.dto.DisasterRequest;
import com.klef.sih.dto.DisasterResponse;
import com.klef.sih.entity.DisasterType;
import com.klef.sih.service.DisasterService;

@RestController
@RequestMapping("/api/disasters")
@CrossOrigin
public class DisasterController 
{

    private final DisasterService disasterService;

    public DisasterController(DisasterService disasterService) {
        this.disasterService = disasterService;
    }

    @PostMapping
    public ResponseEntity<DisasterResponse> createDisaster(
            @RequestBody DisasterRequest request) {

        DisasterResponse response =
                disasterService.createDisaster(request);

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisasterResponse> getDisasterById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                disasterService.getDisasterById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<DisasterResponse>> getAllDisasters() {

        return ResponseEntity.ok(
                disasterService.getAllDisasters()
        );
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<DisasterResponse>> getDisastersByType(
            @PathVariable DisasterType type) {

        return ResponseEntity.ok(
                disasterService.getDisastersByType(type)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisasterResponse> updateDisaster(
            @PathVariable Long id,
            @RequestBody DisasterRequest request) {

        return ResponseEntity.ok(
                disasterService.updateDisaster(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDisaster(
            @PathVariable Long id) {

        disasterService.deleteDisaster(id);

        return ResponseEntity.ok(
                "Disaster deleted successfully"
        );
    }
}