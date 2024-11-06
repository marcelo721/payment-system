package com.marcelo721.payment_system.services.exceptions;

public class UserAccountNotEnabledException extends RuntimeException{
    public UserAccountNotEnabledException(String message){
        super(message);
    }
}
