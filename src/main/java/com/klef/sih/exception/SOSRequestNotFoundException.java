package com.klef.sih.exception;

public class SOSRequestNotFoundException extends RuntimeException
{

    public SOSRequestNotFoundException(String message) {
        super(message);
    }
}