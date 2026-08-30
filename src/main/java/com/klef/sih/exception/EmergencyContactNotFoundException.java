package com.klef.sih.exception;

public class EmergencyContactNotFoundException extends RuntimeException 
{
    public EmergencyContactNotFoundException(String message) 
    {
        super(message);
    }
}