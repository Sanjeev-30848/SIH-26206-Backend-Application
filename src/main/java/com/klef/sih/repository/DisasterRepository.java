package com.klef.sih.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.sih.entity.Disaster;
import com.klef.sih.entity.DisasterType;

@Repository
public interface DisasterRepository
        extends JpaRepository<Disaster, Long> {

    List<Disaster> findByType(DisasterType type);
}