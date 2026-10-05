package com.example.UserAuthentication.customExceptions;

public class UserEmailExistsException extends RuntimeException{
    public UserEmailExistsException(String message){
        super(message);
    }
}
