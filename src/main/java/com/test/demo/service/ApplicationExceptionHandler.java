package com.test.demo.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApplicationExceptionHandler {
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({HttpMessageNotReadableException.class, MethodArgumentNotValidException.class,
        HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<Map<String, String>> handleBadRequestException(Exception e) {
    	Map<String, String> errorResponse = new HashMap<>();

        errorResponse.put("msg", "Numeric input expected, received invalid numbers in input");
        errorResponse.put("status", "FAILED");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleException(
            Exception e) throws IOException {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("msg", e.getLocalizedMessage());
        errorResponse.put("status", "FAILED");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}