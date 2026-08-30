package com.klef.sih.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.sih.entity.EmergencyContact;
import com.klef.sih.entity.EmergencyContactType;

@Repository
public interface EmergencyContactRepository
        extends JpaRepository<EmergencyContact, Long>
{

    List<EmergencyContact> findByType(EmergencyContactType type);

    List<EmergencyContact> findByLocationIgnoreCase(String location);

    List<EmergencyContact> findByActiveTrue();

    List<EmergencyContact> findByLocationIgnoreCaseAndActiveTrue(
            String location);
}