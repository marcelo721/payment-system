package com.marcelo721.payment_system.services.exceptions;

public class EmailUniqueViolationException extends RuntimeException {

    public EmailUniqueViolationException(String message) {
        super(message);
    }
}
