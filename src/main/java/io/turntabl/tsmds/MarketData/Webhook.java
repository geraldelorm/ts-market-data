package io.turntabl.tsmds.MarketData;

import io.turntabl.tsmds.MarketData.Model.MarketData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class Webhook {
    @Autowired
    MarketDataPublisher marketDataPublisher;

    //Sending initial MarketData
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    @Autowired
//    private ChannelTopic channelTopic;
//
//    @Autowired
//    RestTemplate restTemplate;
//
//    List<MarketData> initialMarketDataFromExchange1 = restTemplate.getForObject("https://exchange.matraining.com/md", List.class);
//    List<MarketData> initialMarketDataFromExchange2 = restTemplate.getForObject("https://exchange2.matraining.com/md", List.class);
//
//    @GetMapping
//    public void sendInitialData() {
//        redisTemplate.convertAndSend(channelTopic.getTopic(), initialMarketDataFromExchange1);
//        redisTemplate.convertAndSend(channelTopic.getTopic(), initialMarketDataFromExchange2);
//    }

    @PostMapping("/webhook/md")
    public String setMarketDataFromExchange(@RequestBody List<MarketData> marketDataFromExchange) {
        marketDataPublisher.sendMessage(marketDataFromExchange);
        return "Data from exchange1 sent";
    }

    @PostMapping("/webhook/md2")
    public String setMarketDataFromExchange2(@RequestBody List<MarketData> marketDataFrom2Exchange) {
        marketDataPublisher.sendMessage(marketDataFrom2Exchange);
        return "Data from exchange2 sent";
    }
}
