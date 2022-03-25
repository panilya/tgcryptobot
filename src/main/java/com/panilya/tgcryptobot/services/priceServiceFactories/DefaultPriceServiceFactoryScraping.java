package com.panilya.tgcryptobot.services.priceServiceFactories;

import com.panilya.tgcryptobot.services.PriceService;
import com.panilya.tgcryptobot.services.scrapingservices.BitcoinPriceServiceScraping;
import com.panilya.tgcryptobot.services.scrapingservices.DogecoinPriceServiceScraping;
import com.panilya.tgcryptobot.services.scrapingservices.EthPriceServiceScraping;
import com.panilya.tgcryptobot.services.scrapingservices.LitecoinPriceServiceScraping;

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
}
