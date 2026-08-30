package com.klef.sih.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.sih.entity.Shelter;
import com.klef.sih.entity.ShelterType;

@Repository
public interface ShelterRepository extends JpaRepository<Shelter, Long> 
{

    List<Shelter> findByLocationIgnoreCase(String location);

    List<Shelter> findByType(ShelterType type);

    List<Shelter> findByActiveTrue();

    List<Shelter> findByLocationIgnoreCaseAndActiveTrue(String location);
}