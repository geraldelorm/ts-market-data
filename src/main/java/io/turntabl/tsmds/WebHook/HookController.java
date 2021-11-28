package io.turntabl.tsmds.WebHook;

import io.turntabl.tsmds.MarketData.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/webhook")
public class HookController {

    @Autowired
    HookService hookService;

    @PostMapping("/md")
    public void setMarketDataFromExchange(@RequestBody List<Stock> marketDataFromExchange) {
        hookService.setMarketDataFromExchange(marketDataFromExchange);
    }
}
