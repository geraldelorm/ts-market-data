package io.turntabl.tsmds.WebHook;

import io.turntabl.tsmds.MarketData.Stock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HookService {
    List<Stock> marketDataFromExchange;

    public List<Stock> getMarketDataFromExchange() {
        return marketDataFromExchange;
    }

    public void setMarketDataFromExchange(List<Stock> marketDataFromExchange) {
        this.marketDataFromExchange = marketDataFromExchange;
    }
}
