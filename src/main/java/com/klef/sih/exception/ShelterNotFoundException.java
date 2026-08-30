package com.klef.sih.exception;

public class ShelterNotFoundException extends RuntimeException 
{

    public ShelterNotFoundException(String message) {
        super(message);
    }
}