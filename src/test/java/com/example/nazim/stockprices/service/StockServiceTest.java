package com.example.nazim.stockprices.service;

import com.example.nazim.model.Stock;
import com.example.nazim.service.StockService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StockServiceTest {
    @Autowired
    StockService stockService;

    @DisplayName("Test the end of day stocks service")
    @Test
    public void testGetEODStocks() throws Exception {
        List<Stock> stockList = stockService.getEODStocks("MCD");
        Assertions.assertNotNull(stockList);
        Assertions.assertTrue(stockList.size() > 0);
    }

    @DisplayName("Test the end of day stocks service")
    @Test
    public void testGetSymbol() {
        //TODO:
    }
}
