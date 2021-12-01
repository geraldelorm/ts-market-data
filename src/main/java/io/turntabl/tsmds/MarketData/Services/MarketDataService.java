package io.turntabl.tsmds.MarketData.Services;

import io.turntabl.tsmds.MarketData.Model.MarketData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class MarketDataService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ChannelTopic channelTopic;

    @Autowired
    RestTemplate restTemplate;

    // Sending initial MarketData
    @PostConstruct
    public void sendInitialData() {
        List<MarketData> initialMarketDataFromExchange1 = restTemplate.getForObject("https://exchange.matraining.com/md", List.class);
        List<MarketData> initialMarketDataFromExchange2 = restTemplate.getForObject("https://exchange2.matraining.com/md", List.class);

        redisTemplate.convertAndSend(channelTopic.getTopic(), initialMarketDataFromExchange1.toString());
        redisTemplate.convertAndSend(channelTopic.getTopic(), initialMarketDataFromExchange2.toString());
    }


    public void sendMessage(List<MarketData> marketDataFromExchange) {
        redisTemplate.convertAndSend(channelTopic.getTopic(), marketDataFromExchange.toString());
    }

}
