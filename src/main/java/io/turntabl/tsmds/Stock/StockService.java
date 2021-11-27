package io.turntabl.tsmds.Stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private RestTemplate restTemplate;

    public List<Stock> getAllStocks(){
        String url = "https://exchange2.matraining.com/md";
        List<Stock> stocks = restTemplate.getForObject(url, List.class);
        return stocks;
    }

    public Stock getStock(String ticker) {
        String url = "https://exchange2.matraining.com/md/" + ticker;
        Stock stock = restTemplate.getForObject(url, Stock.class);
        return stock;
    }
}
