package com.example.nazim.Exceptions;

import org.springframework.http.HttpStatus;

public class StockPricesException extends RuntimeException {

    private HttpStatus status;

    public StockPricesException(String message, HttpStatus httpStatus) {
        super(message);
        this.status = httpStatus;
    }
}
