package com.panilya.tgcryptobot.services.priceservice.scrapingservices;

import com.panilya.tgcryptobot.services.priceservice.AbstractPriceServiceScraping;

public class BNBPriceServiceScraping extends AbstractPriceServiceScraping {
    @Override
    protected String doRequest() {
        return "https://coinmarketcap.com/currencies/bnb/";
    }

}
