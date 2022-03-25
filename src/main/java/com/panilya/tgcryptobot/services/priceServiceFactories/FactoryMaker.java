package com.panilya.tgcryptobot.services.priceServiceFactories;

import com.panilya.tgcryptobot.BotConfig;

public class FactoryMaker {

    public static PriceServiceFactory makeFactory(BotConfig.RequestType type) {
        switch (type) {
            case SCRAPING:
                return new DefaultPriceServiceFactoryScraping();
            case API:
                return new DefaultPriceServiceFactoryAPI();
            default:
                throw new IllegalArgumentException("RequestType is not supported");
        }
    }

}
