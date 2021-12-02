package io.turntabl.tsmds.MarketData.Services;

import io.turntabl.tsmds.MarketData.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketDataService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ChannelTopic channelTopic;

    public void sendMessage(List<Product> marketDataFromExchange) {
        redisTemplate.convertAndSend(channelTopic.getTopic(), marketDataFromExchange);
    }

}
