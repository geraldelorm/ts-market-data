package io.turntabl.tsmds.Controller;

import io.turntabl.tsmds.Services.MarketDataService;
import io.turntabl.tsmds.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MarketDataController {
    @Autowired
    MarketDataService marketDataService;

    @Autowired
    RestTemplate restTemplate;

    //TODO
    //Subscribe for market Data Automatically
//    @PostConstruct
//    public void subscribeForMarketData() throws UnknownHostException {
////        restTemplate.postForObject()
//      String webhookUrl1 = "https://" +  InetAddress.getLocalHost().getHostAddress() + "/webhook/md";
//      String webhookUrl2 = "https://" +  InetAddress.getLocalHost().getHostAddress() + "/webhook/md2";
//    }
//
//    @GetMapping
//    public String printHost() throws UnknownHostException {
//        String webhookUrl1 = "https://" +  InetAddress.getLocalHost().getHostAddress() + "/webhook/md";
//        String webhookUrl2 = "https://" +  InetAddress.getLocalHost().getHostAddress() + "/webhook/md2";
//
//        return webhookUrl1 + " and " + webhookUrl2;
//    }
//    @GetMapping("/webhook/md")
//    public String demo(@RequestBody List<MarketData> marketDataFromExchange) {
//        return "Data from exchange1 sent";
//    }

    // Sending initial MarketData
    @PostConstruct
    public void sendInitialData() {
        ArrayList initialMarketDataFromExchange1 = restTemplate.getForObject("https://exchange.matraining.com/md", ArrayList.class);
        ArrayList initialMarketDataFromExchange2 = restTemplate.getForObject("https://exchange2.matraining.com/md", ArrayList.class);

        marketDataService.sendMessageFromExchangeOne(initialMarketDataFromExchange1);
        marketDataService.sendMessageFromExchangeTwo(initialMarketDataFromExchange2);
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
