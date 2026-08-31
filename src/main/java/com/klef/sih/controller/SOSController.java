package com.klef.sih.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.klef.sih.dto.SOSRequestDTO;
import com.klef.sih.dto.SOSResponse;
import com.klef.sih.entity.SOSStatus;
import com.klef.sih.service.SOSService;

@RestController
@RequestMapping("/api/sos")
@CrossOrigin("*	")
public class SOSController
{

    private final SOSService sosService;

    public SOSController(SOSService sosService) {
        this.sosService = sosService;
    }

    @PostMapping
    public ResponseEntity<SOSResponse> createSOS(
            @RequestBody SOSRequestDTO request,
            Authentication authentication) {

        String email = authentication.getName();

        SOSResponse response =
                sosService.createSOS(email, request);

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<SOSResponse> getSOSById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                sosService.getSOSById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<SOSResponse>> getAllSOS() {

        return ResponseEntity.ok(
                sosService.getAllSOS()
        );
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SOSResponse>> getSOSByUser(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                sosService.getSOSByUser(userId)
        );
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<SOSResponse>> getSOSByStatus(
            @PathVariable SOSStatus status) {

        return ResponseEntity.ok(
                sosService.getSOSByStatus(status)
        );
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<SOSResponse> updateSOSStatus(
            @PathVariable Long id,
            @RequestParam SOSStatus status) {

        return ResponseEntity.ok(
                sosService.updateSOSStatus(id, status)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSOS(
            @PathVariable Long id) {

        sosService.deleteSOS(id);

        return ResponseEntity.ok(
                "SOS request deleted successfully"
        );
    }
}