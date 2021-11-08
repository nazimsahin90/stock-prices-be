package com.example.nazim.Exceptions;

import org.springframework.http.HttpStatus;

public class StockPricesException  extends RuntimeException{
private HttpStatus status;
public StockPricesException(String message, HttpStatus status){
    super(message);
    this.status=status;
}
}
