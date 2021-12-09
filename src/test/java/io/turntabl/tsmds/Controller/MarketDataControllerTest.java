package io.turntabl.tsmds.Controller;

import io.turntabl.tsmds.Services.MarketDataService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

class MarketDataControllerTest {
    private AutoCloseable closeable;

    @InjectMocks
    private MarketDataController marketDataController;

    @Mock
    private MarketDataService marketDataService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void openMock() {
        closeable = openMocks(this);
    }

    @AfterEach
    public void closeMock() throws Exception {
        closeable.close();
    }

    @Test
    void itShouldCallRestTemplate2Times_AfterConstructorIsInitialized() {
       marketDataController.sendInitialData();

       verify(restTemplate, times(2)).getForObject(anyString(), any());
    }

    @Test
    void itShouldReturnMessage_WhenReceivedDataFromExchangeOne() {
        String expected = "Data from exchange1 sent";

        assertEquals(expected, marketDataController.setMarketDataFromExchange(List.of()));
    }

    @Test
    void itShouldCallMarketDataServiceOnce_WhenItIsInvoked() {
        marketDataController.setMarketDataFromExchange(List.of());
        marketDataController.setMarketDataFromExchange2(List.of());

        verify(marketDataService, times(1)).sendMessageFromExchangeOne(List.of());
        verify(marketDataService, times(1)).sendMessageFromExchangeTwo(List.of());
    }

    @Test
    void itShouldReturnMessage_WhenReceivedDataFromExchangeTwo() {
        String expected = "Data from exchange2 sent";

        assertEquals(expected, marketDataController.setMarketDataFromExchange2(List.of()));
    }
}