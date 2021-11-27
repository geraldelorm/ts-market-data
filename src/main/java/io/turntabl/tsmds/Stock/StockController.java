package io.turntabl.tsmds.Stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping
    public String home(){
        return "Hello, Welcome to Market Data Service";
    }

    @GetMapping("/stocks")
    public List<Stock> getStocksData(){
        return stockService.getAllStocks();
    }

    @GetMapping("/stocks/{ticker}")
    public Stock getStockDataForTicker(@PathVariable String ticker) {
        return stockService.getStock(ticker);
    }
}
