package com.panilya.tgcryptobot.entities.litecoinEntity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "data"
})
public class Ltc {

    @JsonProperty("status")
    public String status;
    @JsonProperty("data")
    public Data data;

}
