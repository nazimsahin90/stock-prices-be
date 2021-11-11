package com.example.nazim.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST,code=HttpStatus.BAD_REQUEST)
public class BadRequestException extends StockPricesException{

    public BadRequestException(String message){
        super(message, HttpStatus.BAD_REQUEST);
    }

}
