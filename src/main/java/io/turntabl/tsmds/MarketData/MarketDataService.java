package io.turntabl.tsmds.MarketData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MarketDataService {

    @Autowired
    RestTemplate restTemplate;

    List<MarketData> marketData;

    public List<MarketData> getMarketData() {
        if (marketData == null) {
            this.marketData = restTemplate.getForObject("https://exchange2.matraining.com/md", List.class);
        }

        return marketData;
    }

    public String getStockData(String ticker) {
        //fix to return stock
        return ticker + ": Not Found";
    }

    public void updateMarketData(List<MarketData> marketDataFromExchange) {
        this.marketData = marketDataFromExchange;
    }
}
