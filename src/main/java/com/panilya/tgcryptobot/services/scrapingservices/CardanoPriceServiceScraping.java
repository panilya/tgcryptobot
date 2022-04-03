package com.panilya.tgcryptobot.services.scrapingservices;

import com.panilya.tgcryptobot.services.AbstractPriceServiceScraping;

public class CardanoPriceServiceScraping extends AbstractPriceServiceScraping {

    @Override
    protected String doRequest() {
        return "https://coinmarketcap.com/currencies/cardano/";
    }

    @Override
    protected String doGetPercentageOfCoin() {
        return "span[class=sc-15yy2pl-0 feeyND]";
    }
}
