package com.springbootweb.restAPIpractice.advices;

import org.springframework.http.HttpStatus;

public class ApiError {
    private HttpStatus status;

    private String message;
}
