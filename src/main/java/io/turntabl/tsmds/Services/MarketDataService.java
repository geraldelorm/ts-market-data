package io.turntabl.tsmds.Services;

import io.turntabl.tsmds.Model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MarketDataService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    @Qualifier("marketDataFromExOne")
    private ChannelTopic marketDataFromExOne;

    @Autowired
    @Qualifier("marketDataFromExTwo")
    private ChannelTopic marketDataFromExTwo;

    public void sendMessageFromExchangeOne(List<Product> marketDataFromExchange) {
        redisTemplate.convertAndSend(marketDataFromExOne.getTopic(), marketDataFromExchange);
        log.info("Published Message From Ex 1 {}", marketDataFromExchange);
    }

    public void sendMessageFromExchangeTwo(List<Product> marketDataFromExchange) {
        redisTemplate.convertAndSend(marketDataFromExTwo.getTopic(), marketDataFromExchange);
        log.info("Published Message From Ex 2 {}", marketDataFromExchange);
    }

}
