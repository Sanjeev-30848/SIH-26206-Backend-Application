package com.klef.sih.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.sih.dto.AlertRequest;
import com.klef.sih.dto.AlertResponse;
import com.klef.sih.entity.AlertSeverity;
import com.klef.sih.entity.AlertType;
import com.klef.sih.service.AlertService;

@RestController
@RequestMapping("/api/alerts")
@CrossOrigin
public class AlertController
{

    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @PostMapping
    public ResponseEntity<AlertResponse> createAlert(
            @RequestBody AlertRequest request) {

        AlertResponse response =
                alertService.createAlert(request);

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertResponse> getAlertById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                alertService.getAlertById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<AlertResponse>> getAllAlerts() {

        return ResponseEntity.ok(
                alertService.getAllAlerts()
        );
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<AlertResponse>> getAlertsByType(
            @PathVariable AlertType type) {

        return ResponseEntity.ok(
                alertService.getAlertsByType(type)
        );
    }

    @GetMapping("/severity/{severity}")
    public ResponseEntity<List<AlertResponse>> getAlertsBySeverity(
            @PathVariable AlertSeverity severity) {

        return ResponseEntity.ok(
                alertService.getAlertsBySeverity(severity)
        );
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<AlertResponse>> getAlertsByLocation(
            @PathVariable String location) {

        return ResponseEntity.ok(
                alertService.getAlertsByLocation(location)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlertResponse> updateAlert(
            @PathVariable Long id,
            @RequestBody AlertRequest request) {

        return ResponseEntity.ok(
                alertService.updateAlert(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAlert(
            @PathVariable Long id) {

        alertService.deleteAlert(id);

        return ResponseEntity.ok(
                "Alert deleted successfully"
        );
    }
}