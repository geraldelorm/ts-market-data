package io.turntabl.tsmds.MarketData;

import io.turntabl.tsmds.MarketData.Model.MarketData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Component
public class MarketDataPublisher {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ChannelTopic channelTopic;


    public void sendMessage(List<MarketData> marketDataFromExchange) {
        redisTemplate.convertAndSend(channelTopic.getTopic(), marketDataFromExchange);
    }

}
