package com.klef.sih.exception;

public class DisasterNotFoundException extends RuntimeException 
{

    public DisasterNotFoundException(String message) 
    {
        super(message);
    }
}