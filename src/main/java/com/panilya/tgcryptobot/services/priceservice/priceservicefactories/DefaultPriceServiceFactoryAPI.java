package com.panilya.tgcryptobot.services.priceservice.priceservicefactories;

import com.panilya.tgcryptobot.services.priceservice.PriceService;
import com.panilya.tgcryptobot.services.priceservice.apiservices.BitcoinPriceServiceAPI;
import com.panilya.tgcryptobot.services.priceservice.apiservices.DogecoinPriceServiceAPI;
import com.panilya.tgcryptobot.services.priceservice.apiservices.LitecoinPriceServiceAPI;

public class DefaultPriceServiceFactoryAPI implements PriceServiceFactory {

    @Override
    public PriceService createBitcoinPriceService() {
        return new BitcoinPriceServiceAPI();
    }

    @Override
    public PriceService createDogecoinPriceService() {
        return new DogecoinPriceServiceAPI();
    }

    @Override
    public PriceService createEthereumPriceService() {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public PriceService createLitecoinPriceService() {
        return new LitecoinPriceServiceAPI();
    }

    @Override
    public PriceService createSolanaPriceService() {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public PriceService createCardanoPriceService() {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public PriceService createBNBPriceService() {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public PriceService createTerraPriceService() {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public PriceService createXRPPriceService() {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public PriceService createAvalanchePriceService() {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public PriceService createPolkadotPriceService() {
        throw new UnsupportedOperationException("Not supported");
    }
}
