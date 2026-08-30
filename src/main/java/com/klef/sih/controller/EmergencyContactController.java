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

import com.klef.sih.dto.EmergencyContactRequest;
import com.klef.sih.dto.EmergencyContactResponse;
import com.klef.sih.entity.EmergencyContactType;
import com.klef.sih.service.EmergencyContactService;

@RestController
@RequestMapping("/api/emergency-contacts")
@CrossOrigin
public class EmergencyContactController 
{

    private final EmergencyContactService contactService;

    public EmergencyContactController(
            EmergencyContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<EmergencyContactResponse> createContact(
            @RequestBody EmergencyContactRequest request) {

        return new ResponseEntity<>(
                contactService.createContact(request),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<EmergencyContactResponse>>
            getAllContacts() {

        return ResponseEntity.ok(
                contactService.getAllContacts()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmergencyContactResponse>
            getContactById(@PathVariable Long id) {

        return ResponseEntity.ok(
                contactService.getContactById(id)
        );
    }

    @GetMapping("/active")
    public ResponseEntity<List<EmergencyContactResponse>>
            getActiveContacts() {

        return ResponseEntity.ok(
                contactService.getActiveContacts()
        );
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<EmergencyContactResponse>>
            getContactsByType(
                    @PathVariable EmergencyContactType type) {

        return ResponseEntity.ok(
                contactService.getContactsByType(type)
        );
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<EmergencyContactResponse>>
            getContactsByLocation(
                    @PathVariable String location) {

        return ResponseEntity.ok(
                contactService.getContactsByLocation(location)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmergencyContactResponse>
            updateContact(
                    @PathVariable Long id,
                    @RequestBody EmergencyContactRequest request) {

        return ResponseEntity.ok(
                contactService.updateContact(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(
            @PathVariable Long id) {

        contactService.deleteContact(id);

        return ResponseEntity.ok(
                "Emergency contact deleted successfully"
        );
    }
}