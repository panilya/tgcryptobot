package com.panilya.tgcryptobot.services.scrapingservices;

import com.panilya.tgcryptobot.services.AbstractPriceServiceScraping;
import com.panilya.tgcryptobot.settings.ScrapingVars;

public class TerraPriceServiceScraping extends AbstractPriceServiceScraping {
    @Override
    protected String doRequest() {
        return "https://coinmarketcap.com/currencies/terra-luna/";
    }

    @Override
    protected String doGetPercentageOfCoin() {
        return ScrapingVars.JSOUP_PERCENTAGE_gEePkg;
    }
}
