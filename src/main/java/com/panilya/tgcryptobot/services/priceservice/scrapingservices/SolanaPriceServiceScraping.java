package com.panilya.tgcryptobot.services.priceservice.scrapingservices;

import com.panilya.tgcryptobot.services.priceservice.AbstractPriceServiceScraping;

public class SolanaPriceServiceScraping extends AbstractPriceServiceScraping {
    @Override
    protected String doRequest() {
        return "https://coinmarketcap.com/currencies/solana/";
    }

}
