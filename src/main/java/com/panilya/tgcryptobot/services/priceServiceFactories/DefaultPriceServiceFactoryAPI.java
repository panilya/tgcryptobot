package com.panilya.tgcryptobot.services.priceServiceFactories;

import com.panilya.tgcryptobot.services.PriceService;
import com.panilya.tgcryptobot.services.apiServices.BitcoinPriceServiceAPI;
import com.panilya.tgcryptobot.services.apiServices.DogecoinPriceServiceAPI;
import com.panilya.tgcryptobot.services.apiServices.LitecoinPriceServiceAPI;

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
}
