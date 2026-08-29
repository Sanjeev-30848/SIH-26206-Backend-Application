package com.klef.sih.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SOSRequestDTO 
{

    private String message;

    private String location;

}