package com.stackroute.webcontent.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @Value(value = "${data.exception.message1}")
    private String message1;

    @ExceptionHandler
    public ResponseEntity<String> DataNotFoundException(DataNotFoundException dataNotFoundException){
        return new ResponseEntity<>(message1, HttpStatus.CONFLICT);
    }
}
