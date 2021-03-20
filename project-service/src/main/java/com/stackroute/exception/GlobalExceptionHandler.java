package com.stackroute.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value=ProjectNotExistException.class)
    public ResponseEntity<String> userAlreadyExistException(ProjectNotExistException projectNotExistException) {
        return new ResponseEntity<>("Project Not Exist Exist", HttpStatus.CONFLICT);
    }
}
