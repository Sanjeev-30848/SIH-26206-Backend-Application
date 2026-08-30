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

import com.klef.sih.dto.PreparednessRequest;
import com.klef.sih.dto.PreparednessResponse;
import com.klef.sih.entity.PreparednessType;
import com.klef.sih.service.PreparednessService;

@RestController
@RequestMapping("/api/preparedness")
@CrossOrigin
public class PreparednessController
{

    private final PreparednessService preparednessService;

    public PreparednessController(
            PreparednessService preparednessService) {

        this.preparednessService = preparednessService;
    }

    @PostMapping
    public ResponseEntity<PreparednessResponse>
            createPreparedness(
                    @RequestBody PreparednessRequest request) {

        return new ResponseEntity<>(
                preparednessService.createPreparedness(request),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<PreparednessResponse>>
            getAllPreparedness() {

        return ResponseEntity.ok(
                preparednessService.getAllPreparedness()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<PreparednessResponse>
            getPreparednessById(@PathVariable Long id) {

        return ResponseEntity.ok(
                preparednessService.getPreparednessById(id)
        );
    }

    @GetMapping("/active")
    public ResponseEntity<List<PreparednessResponse>>
            getActivePreparedness() {

        return ResponseEntity.ok(
                preparednessService.getActivePreparedness()
        );
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<PreparednessResponse>>
            getByType(
                    @PathVariable PreparednessType type) {

        return ResponseEntity.ok(
                preparednessService.getByType(type)
        );
    }

    @GetMapping("/disaster/{disasterType}")
    public ResponseEntity<List<PreparednessResponse>>
            getByDisasterType(
                    @PathVariable String disasterType) {

        return ResponseEntity.ok(
                preparednessService.getByDisasterType(
                        disasterType)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<PreparednessResponse>
            updatePreparedness(
                    @PathVariable Long id,
                    @RequestBody PreparednessRequest request) {

        return ResponseEntity.ok(
                preparednessService.updatePreparedness(
                        id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePreparedness(
            @PathVariable Long id) {

        preparednessService.deletePreparedness(id);

        return ResponseEntity.ok(
                "Preparedness deleted successfully"
        );
    }
}