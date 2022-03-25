package com.panilya.tgcryptobot.entities.cryptoCoinEntity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "price",
    "price_base",
    "exchange",
    "time"
})
public class Price {

    @JsonProperty("price")
    public String price;
    @JsonProperty("price_base")
    public String priceBase;
    @JsonProperty("exchange")
    public String exchange;
    @JsonProperty("time")
    public long time;

    @Override
    public String toString() {
        return "Price{" +
                "price='" + price + '\'' +
                ", priceBase='" + priceBase + '\'' +
                ", exchange='" + exchange + '\'' +
                '}';
    }
}
