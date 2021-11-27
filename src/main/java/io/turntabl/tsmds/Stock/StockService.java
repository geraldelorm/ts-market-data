package io.turntabl.tsmds.Stock;

import io.turntabl.tsmds.WebHook.HookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    HookService hookService;

    public List<Stock> getAllStocks(){
//        String url = "https://exchange2.matraining.com/md";
//        List<Stock> stocks = restTemplate.getForObject(url, List.class);

        List<Stock> stocks = hookService.getMarketData();
        return stocks;
    }

    public Stock getStock(String ticker) {
//        String url = "https://exchange2.matraining.com/md/" + ticker;
//        Stock stock = restTemplate.getForObject(url, Stock.class);

        Stock stock = hookService.getMarketData().stream().filter(s -> s.getTicker() == ticker).findFirst().get();
        return stock;
    }
}
