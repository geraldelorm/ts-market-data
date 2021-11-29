package io.turntabl.tsmds.MarketData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MarketDataController {

    @Autowired
    MarketDataService marketDataService;

    @GetMapping
    public String home() {
        return "Hello, Welcome to Market Data Service";
    }

    @GetMapping("/stocks")
    public List<MarketData> getStocksData() {
        return marketDataService.getMarketData();
    }

    @GetMapping("/stocks/{ticker}")
    public String getStockDataForTicker(@PathVariable String ticker) {
        return marketDataService.getStockData(ticker);
    }
}
