package com.example.nazim.controller;

import java.util.ArrayList;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.nazim.model.Stock;
import com.example.nazim.service.StockService;

@RestController
@CrossOrigin(origins = "*")
public class StockController {

    @Autowired
    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/stocks/{symbol}")
    public ArrayList<Stock> getStocks(@PathVariable @NotNull String symbol) throws Exception {
        return stockService.getEODStocks(symbol);
    }

    @GetMapping("/stock-symbols")
    public ArrayList<String> getStockSymbols() throws Exception {
        return stockService.getStockSymbols();
    }
}
