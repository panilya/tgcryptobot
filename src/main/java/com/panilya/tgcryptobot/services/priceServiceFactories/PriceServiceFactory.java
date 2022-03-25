package com.panilya.tgcryptobot.services.priceServiceFactories;

import com.panilya.tgcryptobot.services.PriceService;

public interface PriceServiceFactory {

    PriceService createBitcoinPriceService();

    PriceService createDogecoinPriceService();

    PriceService createEthereumPriceService();

    PriceService createLitecoinPriceService();

}
