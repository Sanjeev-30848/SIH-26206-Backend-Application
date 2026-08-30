package com.klef.sih.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler 
{

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(
            UserNotFoundException ex) {

        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(SOSRequestNotFoundException.class)
    public ResponseEntity<String> handleSOSRequestNotFoundException(
            SOSRequestNotFoundException ex) {

        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(DisasterNotFoundException.class)
    public ResponseEntity<String> handleDisasterNotFoundException(
            DisasterNotFoundException ex) {

        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<String> handleUnauthorizedException(
            UnauthorizedException ex) {

        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.UNAUTHORIZED
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(
            Exception ex) {

        return new ResponseEntity<>(
                "An unexpected error occurred.",
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
    
    @ExceptionHandler(AlertNotFoundException.class)
    public ResponseEntity<String> handleAlertNotFoundException(
            AlertNotFoundException ex) {

        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.NOT_FOUND
        );
    }
    
    @ExceptionHandler(EmergencyContactNotFoundException.class)
    public ResponseEntity<String> handleEmergencyContactNotFound(
            EmergencyContactNotFoundException ex) {

        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.NOT_FOUND
        );
    }
    
    @ExceptionHandler(PreparednessNotFoundException.class)
    public ResponseEntity<String> handlePreparednessNotFound(
            PreparednessNotFoundException ex) {

        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.NOT_FOUND
        );
    }
}