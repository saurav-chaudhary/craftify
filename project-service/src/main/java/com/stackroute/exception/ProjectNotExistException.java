package com.stackroute.exception;

public class ProjectNotExistException extends RuntimeException{
    public String message;
    public ProjectNotExistException() {
    }

    public ProjectNotExistException(String message) {
        super();
        this.message = message;
    }
}
