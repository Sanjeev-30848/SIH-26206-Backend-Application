package com.klef.sih.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.klef.sih.dto.SOSRequestDTO;
import com.klef.sih.dto.SOSResponse;
import com.klef.sih.entity.SOSRequest;
import com.klef.sih.entity.SOSStatus;
import com.klef.sih.entity.User;
import com.klef.sih.exception.SOSRequestNotFoundException;
import com.klef.sih.exception.UserNotFoundException;
import com.klef.sih.repository.SOSRequestRepository;
import com.klef.sih.repository.UserRepository;

@Service
public class SOSServiceImpl implements SOSService
{

    private final SOSRequestRepository sosRequestRepository;
    private final UserRepository userRepository;

    public SOSServiceImpl(
            SOSRequestRepository sosRequestRepository,
            UserRepository userRepository) {

        this.sosRequestRepository = sosRequestRepository;
        this.userRepository = userRepository;
    }

    @Override
    public SOSResponse createSOS(
            String email,
            SOSRequestDTO request) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(
                        "User not found with email: " + email));

        SOSRequest sosRequest = new SOSRequest();

        sosRequest.setUser(user);
        sosRequest.setMessage(request.getMessage());
        sosRequest.setLocation(request.getLocation());
        sosRequest.setStatus(SOSStatus.PENDING);

        SOSRequest savedSOS =
                sosRequestRepository.save(sosRequest);

        return convertToResponse(savedSOS);
    }

    @Override
    public SOSResponse getSOSById(Long id) {

        SOSRequest sosRequest =
                sosRequestRepository.findById(id)
                        .orElseThrow(() ->
                                new SOSRequestNotFoundException(
                                        "SOS request not found with ID: " + id));

        return convertToResponse(sosRequest);
    }

    @Override
    public List<SOSResponse> getAllSOS() {

        return sosRequestRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<SOSResponse> getSOSByUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(
                        "User not found with ID: " + userId));

        return sosRequestRepository.findByUser(user)
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<SOSResponse> getSOSByStatus(
            SOSStatus status) {

        return sosRequestRepository.findByStatus(status)
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public SOSResponse updateSOSStatus(
            Long id,
            SOSStatus status) {

        SOSRequest sosRequest =
                sosRequestRepository.findById(id)
                        .orElseThrow(() ->
                                new SOSRequestNotFoundException(
                                        "SOS request not found with ID: " + id));

        sosRequest.setStatus(status);

        SOSRequest updatedSOS =
                sosRequestRepository.save(sosRequest);

        return convertToResponse(updatedSOS);
    }

    @Override
    public void deleteSOS(Long id) {

        if (!sosRequestRepository.existsById(id)) {

            throw new SOSRequestNotFoundException(
                    "SOS request not found with ID: " + id);
        }

        sosRequestRepository.deleteById(id);
    }

    private SOSResponse convertToResponse(
            SOSRequest sosRequest) {

        return new SOSResponse(
                sosRequest.getId(),
                sosRequest.getUser().getId(),
                sosRequest.getUser().getName(),
                sosRequest.getMessage(),
                sosRequest.getLocation(),
                sosRequest.getStatus(),
                sosRequest.getCreatedAt(),
                sosRequest.getUpdatedAt()
        );
    }
}