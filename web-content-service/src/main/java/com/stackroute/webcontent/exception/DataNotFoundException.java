package com.stackroute.webcontent.exception;

public class DataNotFoundException extends RuntimeException{
    private String message;

    public DataNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public DataNotFoundException() {
    }
}
