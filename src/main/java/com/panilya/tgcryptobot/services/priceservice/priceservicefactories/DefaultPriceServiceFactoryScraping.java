package com.panilya.tgcryptobot.services.priceservice.priceservicefactories;

import com.panilya.tgcryptobot.services.priceservice.PriceService;
import com.panilya.tgcryptobot.services.priceservice.scrapingservices.*;

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

    @Override
    public PriceService createBNBPriceService() {
        return new BNBPriceServiceScraping();
    }

    @Override
    public PriceService createTerraPriceService() {
        return new TerraPriceServiceScraping();
    }

    @Override
    public PriceService createXRPPriceService() {
        return new XRPPriceServiceScraping();
    }

    @Override
    public PriceService createAvalanchePriceService() {
        return new AvalanchePriceServiceScraping();
    }

    @Override
    public PriceService createPolkadotPriceService() {
        return new PolkadotPriceService();
    }
}
