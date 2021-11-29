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

    @GetMapping("/md")
    public List<MarketData> getMarketData() {
        return marketDataService.getMarketData();
    }

    @GetMapping("/md2")
    public List<MarketData> getMarketData2() {
        return marketDataService.getMarketData2();
    }

    @GetMapping("/md/{ticker}")
    public String getMarketDataForTicker(@PathVariable String ticker) {
        return marketDataService.getMarketDataForTicker(ticker);
    }

    @GetMapping("/md2/{ticker}")
    public String getMarketData2ForTicker(@PathVariable String ticker) {
        return marketDataService.getMarketData2ForTicker(ticker);
    }

}
