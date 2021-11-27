package io.turntabl.tsmds.WebHook;

import io.turntabl.tsmds.Stock.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class HookController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    HookService hookService;

    @PostMapping("/webhook")
    public void setStockDataFromWebHook(@RequestBody List<Stock> stockDataFromWebHook) {
//        List<Stock> stocksData = restTemplate.getForObject(stockDataFromWebHook, List.class);

        hookService.setMarketData(stockDataFromWebHook);
    }
}
