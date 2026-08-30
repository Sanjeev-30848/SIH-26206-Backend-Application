package com.klef.sih.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.klef.sih.dto.EmergencyContactRequest;
import com.klef.sih.dto.EmergencyContactResponse;
import com.klef.sih.entity.EmergencyContact;
import com.klef.sih.entity.EmergencyContactType;
import com.klef.sih.exception.EmergencyContactNotFoundException;
import com.klef.sih.repository.EmergencyContactRepository;

@Service
public class EmergencyContactServiceImpl
        implements EmergencyContactService {

    private final EmergencyContactRepository contactRepository;

    public EmergencyContactServiceImpl(
            EmergencyContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public EmergencyContactResponse createContact(
            EmergencyContactRequest request) {

        EmergencyContact contact = new EmergencyContact();

        contact.setName(request.getName());
        contact.setPhoneNumber(request.getPhoneNumber());
        contact.setEmail(request.getEmail());
        contact.setDepartment(request.getDepartment());
        contact.setLocation(request.getLocation());
        contact.setType(request.getType());
        contact.setActive(request.getActive());

        EmergencyContact saved =
                contactRepository.save(contact);

        return convertToResponse(saved);
    }

    @Override
    public EmergencyContactResponse getContactById(Long id) {

        EmergencyContact contact =
                contactRepository.findById(id)
                .orElseThrow(() ->
                    new EmergencyContactNotFoundException(
                        "Emergency contact not found with ID: " + id));

        return convertToResponse(contact);
    }

    @Override
    public List<EmergencyContactResponse> getAllContacts() {

        return contactRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmergencyContactResponse> getActiveContacts() {

        return contactRepository.findByActiveTrue()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmergencyContactResponse> getContactsByType(
            EmergencyContactType type) {

        return contactRepository.findByType(type)
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmergencyContactResponse> getContactsByLocation(
            String location) {

        return contactRepository
                .findByLocationIgnoreCaseAndActiveTrue(location)
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EmergencyContactResponse updateContact(
            Long id,
            EmergencyContactRequest request) {

        EmergencyContact contact =
                contactRepository.findById(id)
                .orElseThrow(() ->
                    new EmergencyContactNotFoundException(
                        "Emergency contact not found with ID: " + id));

        contact.setName(request.getName());
        contact.setPhoneNumber(request.getPhoneNumber());
        contact.setEmail(request.getEmail());
        contact.setDepartment(request.getDepartment());
        contact.setLocation(request.getLocation());
        contact.setType(request.getType());
        contact.setActive(request.getActive());

        EmergencyContact updated =
                contactRepository.save(contact);

        return convertToResponse(updated);
    }

    @Override
    public void deleteContact(Long id) {

        if (!contactRepository.existsById(id)) {
            throw new EmergencyContactNotFoundException(
                    "Emergency contact not found with ID: " + id);
        }

        contactRepository.deleteById(id);
    }

    private EmergencyContactResponse convertToResponse(
            EmergencyContact contact) {

        return new EmergencyContactResponse(
                contact.getId(),
                contact.getName(),
                contact.getPhoneNumber(),
                contact.getEmail(),
                contact.getDepartment(),
                contact.getLocation(),
                contact.getType(),
                contact.getActive(),
                contact.getCreatedAt(),
                contact.getUpdatedAt()
        );
    }
}