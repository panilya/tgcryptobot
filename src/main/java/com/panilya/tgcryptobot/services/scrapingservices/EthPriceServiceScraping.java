package com.panilya.tgcryptobot.services.scrapingservices;

import com.panilya.tgcryptobot.services.AbstractPriceServiceScraping;

public class EthPriceServiceScraping extends AbstractPriceServiceScraping {

    @Override
    protected String doRequest() {
        return "https://coinmarketcap.com/currencies/ethereum/";
    }
}
