package com.panilya.tgcryptobot.entities.cryptoCoinEntity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "network",
    "prices"
})
public class Data {

    @JsonProperty("network")
    public String network;
    @JsonProperty("prices")
    public List<Price> prices;

    @Override
    public String toString() {
        return "Data{" +
                "network='" + network + '\'' +
                ", prices=" + prices +
                '}';
    }
}
