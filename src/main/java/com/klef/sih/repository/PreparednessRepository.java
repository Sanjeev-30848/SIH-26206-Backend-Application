package com.klef.sih.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.sih.entity.Preparedness;
import com.klef.sih.entity.PreparednessType;

@Repository
public interface PreparednessRepository
        extends JpaRepository<Preparedness, Long> 
{

    List<Preparedness> findByType(PreparednessType type);

    List<Preparedness> findByDisasterTypeIgnoreCase(
            String disasterType);

    List<Preparedness> findByActiveTrue();

    List<Preparedness> findByDisasterTypeIgnoreCaseAndActiveTrue(
            String disasterType);
}