package io.turntabl.tsmds.WebHook;

import io.turntabl.tsmds.Stock.Stock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HookService {

    List<Stock> marketData;

    public List<Stock> getMarketData() {
        return marketData;
    }

    public void setMarketData(List<Stock> marketData) {
        this.marketData = marketData;
    }
}
