package com.example.nazim.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.example.nazim.Exceptions.BadRequestException;
import com.example.nazim.Exceptions.ForbiddenException;
import com.example.nazim.model.SymbolItem;
import lombok.Getter;
import org.springframework.aop.framework.autoproxy.BeanFactoryAdvisorRetrievalHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.nazim.config.ApplicationProperties;
import com.example.nazim.model.EndOfDayStockItem;
import com.example.nazim.model.Stock;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StockService {

    private String PERIOD = "d";

    // @Getter
    private ArrayList<String> symbol_list = new ArrayList<String>();

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    private final ApplicationProperties applicationProperties;

    @Autowired
    public StockService(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    protected HttpHeaders createHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }

    public ArrayList<Stock> getEODStocks(String symbol) throws Exception {

        LocalDateTime nowDate = LocalDateTime.now();
        String date_to = nowDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDateTime fromDate = nowDate.minusYears(1);
        //LocalDateTime fromDate = nowDate.minusDays(30);
        String date_from = fromDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        ArrayList<Stock> stockList = new ArrayList<Stock>();

        String url = applicationProperties.getDataUrl() + applicationProperties.getEodPath() + symbol.toUpperCase() + ".US?from="
                + date_from + "&to=" + date_to + "&api_token=" + applicationProperties.getApiToken() + "&period=" + PERIOD + "&fmt=json";
        HttpEntity<String> request = new HttpEntity<>(createHttpHeaders());

        ResponseEntity<EndOfDayStockItem[]> response = this.restTemplate().exchange(url, HttpMethod.GET, request,
                EndOfDayStockItem[].class);

        if (response.getStatusCode() == HttpStatus.OK) {
            log.info("response modeling " + (response.getBody() != null ? response.getBody().length : 0));
            for (EndOfDayStockItem item : response.getBody()) {
                Stock stock = new Stock();
                LocalDate date = LocalDate.parse(item.getDate());
                LocalDateTime localDateTime = date.atStartOfDay();
                long millis = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                stock.setAdjPrice(item.getAdjPrice());
                stock.setDate(millis);
                stockList.add(stock);
            }
            return stockList;
        } else {
            throw new Exception("Error happened on EODHistorical service status code : " + response.getStatusCode());
        }
    }

    public ArrayList<String> getStockSymbols() throws Exception {
        HttpEntity<String> request = new HttpEntity<>(createHttpHeaders());

        String symbol_url = applicationProperties.getDataUrl() + applicationProperties.getSymPath() + "US?api_token="
                + applicationProperties.getApiToken() + "&fmt=json";
        log.info("symbol url: " + symbol_url);
        ResponseEntity<SymbolItem[]> response = this.restTemplate().exchange(symbol_url, HttpMethod.GET, request,
                SymbolItem[].class);
        if (response.getStatusCode() == HttpStatus.OK) {

            for (SymbolItem item : response.getBody()) {
                if (item.getType().equals("Common Stock")) {
                    symbol_list.add(item.getCode());
                }
            }
            log.info("symbol count " + symbol_list.size());
            return symbol_list;
        } else {
            throw new Exception("Error happened on Symbol service status code : " + response.getStatusCode());
        }
    }
}
