package com.panilya.tgcryptobot.services.priceservice.scrapingservices;

import com.panilya.tgcryptobot.services.priceservice.AbstractPriceServiceScraping;

public class TerraPriceServiceScraping extends AbstractPriceServiceScraping {
    @Override
    protected String doRequest() {
        return "https://coinmarketcap.com/currencies/terra-luna/";
    }

}
