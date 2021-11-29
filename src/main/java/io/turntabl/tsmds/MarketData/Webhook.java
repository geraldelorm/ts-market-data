package io.turntabl.tsmds.MarketData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/webhook")
public class Webhook {
    @Autowired
    MarketDataService marketDataService;

    @PostMapping("/md")
    public String setMarketDataFromExchange(@RequestBody List<MarketData> marketDataFromExchange) {
        marketDataService.updateMarketData(marketDataFromExchange);
        return "data submitted";
    }

    @PostMapping("/md2")
    public String setMarketDataFromExchange2(@RequestBody List<MarketData> marketDataFromExchange) {
        marketDataService.updateMarketData2(marketDataFromExchange);
        return "data submitted";
    }
}
