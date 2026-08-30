package com.klef.sih.service;

import org.springframework.stereotype.Service;

import com.klef.sih.dto.DashboardResponse;
import com.klef.sih.entity.EmergencyStatus;
import com.klef.sih.repository.AlertRepository;
import com.klef.sih.repository.DisasterRepository;
import com.klef.sih.repository.EmergencyRepository;
import com.klef.sih.repository.SOSRequestRepository;
import com.klef.sih.repository.ShelterRepository;
import com.klef.sih.repository.UserRepository;

@Service
public class DashboardServiceImpl implements DashboardService 
{

    private final UserRepository userRepository;
    private final SOSRequestRepository sosRequestRepository;
    private final AlertRepository alertRepository;
    private final ShelterRepository shelterRepository;
    private final DisasterRepository disasterRepository;
    private final EmergencyRepository emergencyRepository;

    public DashboardServiceImpl(
            UserRepository userRepository,
            SOSRequestRepository sosRequestRepository,
            AlertRepository alertRepository,
            ShelterRepository shelterRepository,
            DisasterRepository disasterRepository,
            EmergencyRepository emergencyRepository) {

        this.userRepository = userRepository;
        this.sosRequestRepository = sosRequestRepository;
        this.alertRepository = alertRepository;
        this.shelterRepository = shelterRepository;
        this.disasterRepository = disasterRepository;
        this.emergencyRepository = emergencyRepository;
    }

    @Override
    public DashboardResponse getDashboard() {

        long totalUsers =
                userRepository.count();

        long totalSosRequests =
                sosRequestRepository.count();

        long activeAlerts =
                alertRepository.count();

        long availableShelters =
                shelterRepository.count();

        long totalDisasters =
                disasterRepository.count();

        long pendingEmergencies =
                emergencyRepository
                        .findByStatus(EmergencyStatus.PENDING)
                        .size();

        return new DashboardResponse(
                totalUsers,
                totalSosRequests,
                pendingEmergencies,
                activeAlerts,
                availableShelters,
                totalDisasters
        );
    }
}