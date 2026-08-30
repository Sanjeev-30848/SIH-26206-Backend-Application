package com.klef.sih.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.sih.entity.Emergency;
import com.klef.sih.entity.EmergencyStatus;

@Repository
public interface EmergencyRepository extends JpaRepository<Emergency, Long>
{

    List<Emergency> findByUserId(Long userId);

    List<Emergency> findByStatus(EmergencyStatus status);

    List<Emergency> findByLocationIgnoreCase(String location);

    List<Emergency> findByUserIdAndStatus(
            Long userId,
            EmergencyStatus status);
}