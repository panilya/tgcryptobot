package com.panilya.tgcryptobot.services.scrapingservices;

import com.panilya.tgcryptobot.services.AbstractPriceServiceScraping;
import com.panilya.tgcryptobot.settings.ScrapingVars;

public class AvalanchePriceServiceScraping extends AbstractPriceServiceScraping {

    @Override
    protected String doRequest() {
        return "https://coinmarketcap.com/currencies/avalanche/";
    }

    @Override
    protected String doGetPercentageOfCoin() {
        return ScrapingVars.JSOUP_PERCENTAGE_feeyND;
    }
}
