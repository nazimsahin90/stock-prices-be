package com.example.nazim.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleCustomException(Exception ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        ResponseEntity<Object> responseEntity;
        if (ex instanceof HttpClientErrorException) {
            responseEntity = new ResponseEntity<>(body, ((HttpClientErrorException) ex).getStatusCode());
        } else {
            responseEntity = new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}

