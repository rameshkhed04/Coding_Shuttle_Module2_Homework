package com.springbootweb.restAPIpractice.advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExecptionHandler {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> resourcesnotfound(NoSuchElementException exception){
        return new ResponseEntity<>("Resource not found", HttpStatus.NOT_FOUND);
    }

}
