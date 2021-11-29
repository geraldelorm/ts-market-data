//package io.turntabl.tsmds.RedisConfig;
//
//import io.turntabl.tsmds.MarketData.MarketData;
//import io.turntabl.tsmds.MarketData.MarketDataService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.listener.ChannelTopic;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class RedisMessagePublisher {
//
//    @Autowired
//    private MarketDataService marketDataService;
//
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    @Autowired
//    private ChannelTopic channelTopic;
//
//    // TODO Configure URL with Subscription Webhook URL
////    @ApiOperation("Subscription to Exchange Data Webhook")
//
//    @PostMapping("/publish")
//    public String publish(@RequestBody List<MarketData> message) {
//        redisTemplate.convertAndSend(channelTopic.getTopic(), message);
//        return "Message Published";
//    }
//}
//
//
