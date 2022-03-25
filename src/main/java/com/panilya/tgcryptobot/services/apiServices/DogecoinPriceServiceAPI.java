package com.panilya.tgcryptobot.services.apiServices;

import com.panilya.tgcryptobot.services.AbstractPriceServiceAPI;
import org.apache.http.client.methods.HttpGet;

public class DogecoinPriceServiceAPI extends AbstractPriceServiceAPI {

    @Override
    protected HttpGet doRequest() {
        return new HttpGet("https://chain.so/api/v2/get_price/DOGE/USD");
    }
}
