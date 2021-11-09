package com.example.nazim;

import com.example.nazim.service.StockService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class StockPricesApplication implements ApplicationRunner {

//	@Autowired
//	StockService stockService;

	public static void main(String[] args) {
		SpringApplication.run(StockPricesApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
//		log.info("stock symbol gather:");
//		stockService.getStockSymbols();
	}

}
