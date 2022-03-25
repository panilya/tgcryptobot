package com.panilya.tgcryptobot.services.scrapingservices;

import com.panilya.tgcryptobot.services.AbstractPriceServiceScraping;

public class LitecoinPriceServiceScraping extends AbstractPriceServiceScraping {
    @Override
    protected String doRequest() {
        return "https://coinmarketcap.com/currencies/litecoin/";
    }
}
