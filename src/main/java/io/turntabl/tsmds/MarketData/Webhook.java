package io.turntabl.tsmds.MarketData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/webhook")
public class Webhook {
    @Autowired
    MarketDataService marketDataService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ChannelTopic channelTopic;

    @PostMapping("/md")
    public String setMarketDataFromExchange(@RequestBody List<MarketData> marketDataFromExchange) {
        //send data to listener
        redisTemplate.convertAndSend(channelTopic.getTopic(), marketDataFromExchange);

        marketDataService.updateMarketData(marketDataFromExchange);
        return "data submitted and data should be published";
    }

    @PostMapping("/md2")
    public String setMarketDataFromExchange2(@RequestBody List<MarketData> marketDataFromExchange) {
        //send data to listener
        redisTemplate.convertAndSend(channelTopic.getTopic(), marketDataFromExchange);

        marketDataService.updateMarketData2(marketDataFromExchange);
        return "data submitted and data should be published";
    }
}
