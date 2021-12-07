package io.turntabl.tsmds.Controller;

import io.turntabl.tsmds.Services.MarketDataService;
import io.turntabl.tsmds.Model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class MarketDataController {
    @Autowired
    MarketDataService marketDataService;

    @Autowired
    RestTemplate restTemplate;

    //TODO
    //Subscribe for market Data Automatically

    @PostConstruct
    public void sendInitialData() {
        Product[] initialMarketDataFromExchange1 = restTemplate.getForObject("https://exchange.matraining.com/md", Product[].class);
        Product[] initialMarketDataFromExchange2 = restTemplate.getForObject("https://exchange2.matraining.com/md", Product[].class);

        if (initialMarketDataFromExchange1 != null) {
            marketDataService.sendMessageFromExchangeOne(Arrays.asList(initialMarketDataFromExchange1));
        }

        if (initialMarketDataFromExchange2 != null) {
            marketDataService.sendMessageFromExchangeTwo(Arrays.asList(initialMarketDataFromExchange2));
        }
    }

    @PostMapping("/webhook/md")
    public String setMarketDataFromExchange(@RequestBody List<Product> productFromExchange) {
        marketDataService.sendMessageFromExchangeOne(productFromExchange);
        return "Data from exchange1 sent";
    }

    @PostMapping("/webhook/md2")
    public String setMarketDataFromExchange2(@RequestBody List<Product> productFromExchange2) {
        marketDataService.sendMessageFromExchangeTwo(productFromExchange2);
        return "Data from exchange2 sent";
    }
}
