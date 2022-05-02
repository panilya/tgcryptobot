package com.panilya.tgcryptobot.services.priceservice.apiservices;

import com.panilya.tgcryptobot.services.priceservice.AbstractPriceServiceAPI;
import org.apache.http.client.methods.HttpGet;

public class LitecoinPriceServiceAPI extends AbstractPriceServiceAPI {

    @Override
    protected HttpGet doRequest() {
        return new HttpGet("https://chain.so/api/v2/get_price/LTC/USD");
    }
}
