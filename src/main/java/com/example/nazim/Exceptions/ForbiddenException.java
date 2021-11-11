package com.example.nazim.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.FORBIDDEN,code=HttpStatus.FORBIDDEN)
public class ForbiddenException extends StockPricesException {

    public ForbiddenException(String message) {
        super(message, HttpStatus.FORBIDDEN);
    }

}
