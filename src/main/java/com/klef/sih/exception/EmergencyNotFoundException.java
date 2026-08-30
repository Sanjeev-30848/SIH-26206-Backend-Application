package com.klef.sih.exception;

public class EmergencyNotFoundException extends RuntimeException 
{
    public EmergencyNotFoundException(String message) {
        super(message);
    }
}