package com.panilya.tgcryptobot.services.priceservicefactories;

import com.panilya.tgcryptobot.services.PriceService;
import com.panilya.tgcryptobot.services.scrapingservices.*;

public class DefaultPriceServiceFactoryScraping implements PriceServiceFactory {

    @Override
    public PriceService createBitcoinPriceService() {
        return new BitcoinPriceServiceScraping();
    }

    @Override
    public PriceService createDogecoinPriceService() {
        return new DogecoinPriceServiceScraping();
    }

    @Override
    public PriceService createEthereumPriceService() {
        return new EthPriceServiceScraping();
    }

    @Override
    public PriceService createLitecoinPriceService() {
        return new LitecoinPriceServiceScraping();
    }

    @Override
    public PriceService createSolanaPriceService() {
        return new SolanaPriceServiceScraping();
    }

    @Override
    public PriceService createCardanoPriceService() {
        return new CardanoPriceServiceScraping();
    }
}
