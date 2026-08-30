package com.klef.sih.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.sih.entity.Alert;
import com.klef.sih.entity.AlertSeverity;
import com.klef.sih.entity.AlertType;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {

    List<Alert> findByType(AlertType type);

    List<Alert> findBySeverity(AlertSeverity severity);

    List<Alert> findByLocationIgnoreCase(String location);
}