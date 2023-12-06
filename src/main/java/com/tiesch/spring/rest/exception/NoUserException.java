package com.tiesch.spring.rest.exception;

public class NoUserException extends RuntimeException{

    public NoUserException(String message) {
        super(message);
    }
}
