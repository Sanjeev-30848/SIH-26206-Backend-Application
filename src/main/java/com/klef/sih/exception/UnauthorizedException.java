package com.klef.sih.exception;

public class UnauthorizedException extends RuntimeException
{

    public UnauthorizedException(String message) {
        super(message);
    }
}