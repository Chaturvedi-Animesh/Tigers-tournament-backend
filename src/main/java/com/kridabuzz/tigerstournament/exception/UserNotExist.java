package com.kridabuzz.tigerstournament.exception;

public class UserNotExist extends RuntimeException{
    public UserNotExist(String message){
        super(message);
    }
}
