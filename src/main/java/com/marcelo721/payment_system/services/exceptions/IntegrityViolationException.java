package com.marcelo721.payment_system.services.exceptions;

public class IntegrityViolationException extends RuntimeException {

    public IntegrityViolationException(String message) {
        super(message);
    }
}
