package com.klef.sih.dto;

import java.time.LocalDateTime;

import com.klef.sih.entity.SOSStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SOSResponse 
{

    private Long id;

    private Long userId;

    private String userName;

    private String message;

    private String location;

    private SOSStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}