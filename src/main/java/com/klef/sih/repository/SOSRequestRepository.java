package com.klef.sih.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.sih.entity.SOSRequest;
import com.klef.sih.entity.SOSStatus;
import com.klef.sih.entity.User;

@Repository
public interface SOSRequestRepository extends JpaRepository<SOSRequest, Long>
{

    List<SOSRequest> findByUser(User user);

    List<SOSRequest> findByStatus(SOSStatus status);

}