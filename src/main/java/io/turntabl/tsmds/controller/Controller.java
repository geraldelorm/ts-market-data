package io.turntabl.tsmds.controller;

import io.turntabl.tsmds.Data.StockData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String home(){
        return "Hello, Welcome to Market Data Service";
    }

    @GetMapping("/stocksData")
    public List<StockData> getStocksData(){
        String url = "https://exchange2.matraining.com/md";
        List<StockData> stocks = restTemplate.getForObject(url, List.class);
        return stocks;
    }

    @GetMapping("/stocksData/{ticker}")
    public StockData getStockDataForTicker(@PathVariable String ticker) {
        String url = "https://exchange2.matraining.com/md/" + ticker;
        StockData stockData = restTemplate.getForObject(url, StockData.class);
        return stockData;
    }
}
