package com.marcelo721.payment_system.services.exceptions;

public class PasswordInvalidException extends RuntimeException{
    public PasswordInvalidException(String message){
        super(message);
    }
}
