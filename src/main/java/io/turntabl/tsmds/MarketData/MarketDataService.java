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

    List<MarketData> marketData2;

    public List<MarketData> getMarketData() {
        if (marketData == null) {
            this.marketData = restTemplate.getForObject("https://exchange.matraining.com/md", List.class);
        }

        return marketData;
    }

    public List<MarketData> getMarketData2() {
        if (marketData2 == null) {
            this.marketData2 = restTemplate.getForObject("https://exchange2.matraining.com/md", List.class);
        }

        return marketData2;
    }

    public String getMarketDataForTicker(String ticker) {
        //fix to return stock
        return ticker + ": Not Found";
    }

    public String getMarketData2ForTicker(String ticker) {
        //fix to return stock
        return ticker + ": Not Found";
    }

    public void updateMarketData(List<MarketData> marketDataFromExchange) {
        this.marketData = marketDataFromExchange;
    }

    public void updateMarketData2(List<MarketData> marketDataFromExchange) {
        this.marketData2 = marketDataFromExchange;
    }
}
