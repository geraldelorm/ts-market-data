package io.turntabl.tsmds.MarketData.Controller;

import io.turntabl.tsmds.MarketData.Services.MarketDataService;
import io.turntabl.tsmds.MarketData.Model.MarketData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@RestController
public class MarketDataController {
    @Autowired
    MarketDataService marketDataService;

    @Autowired
    RestTemplate restTemplate;


    //Subscribe for market Data
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
//        return webhookUrl1 + "and" + webhookUrl2;
//    }

    @PostMapping("/webhook/md")
    public String setMarketDataFromExchange(@RequestBody List<MarketData> marketDataFromExchange) {
        marketDataService.sendMessage(marketDataFromExchange);
        return "Data from exchange1 sent";
    }

    @PostMapping("/webhook/md2")
    public String setMarketDataFromExchange2(@RequestBody List<MarketData> marketDataFromExchange2) {
        System.out.println();
        marketDataService.sendMessage(marketDataFromExchange2);
        return "Data from exchange2 sent";
    }
}
