package com.panilya.tgcryptobot.entities.dogeEntity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "data"
})
public class Doge {

    @JsonProperty("status")
    public String status;
    @JsonProperty("data")
    public Data data;

}
