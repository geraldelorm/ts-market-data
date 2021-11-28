package io.turntabl.tsmds.MarketData;

import io.turntabl.tsmds.WebHook.HookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MarketDataService {
    @Autowired
    HookService hookService;

    @Autowired
    RestTemplate restTemplate;

    public List<Stock> getMarketData() {
        if (hookService.getMarketDataFromExchange() == null) {
            List<Stock> marketData = restTemplate.getForObject("https://exchange2.matraining.com/md", List.class);
            return marketData;
        }

        List<Stock> marketData = hookService.getMarketDataFromExchange();
        return marketData;
    }

    public String getStockData(String ticker) {
        //fix to return stock
        return ticker + ": Not Found";
    }
}
