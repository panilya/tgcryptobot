package com.panilya.tgcryptobot.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.panilya.tgcryptobot.entities.cryptoCoinEntity.CryptoCoinEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.IOException;

public abstract class AbstractPriceServiceAPI implements PriceService {

    Logger LOGGER = LoggerFactory.getLogger(AbstractPriceServiceAPI.class);

    @Override
    public SendMessage doGetCurrencyPrice(Message message) throws IOException {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            ObjectMapper mapper = new ObjectMapper();
            CryptoCoinEntity response = client.execute(doRequest(), httpResponse ->
                    mapper.readValue(httpResponse.getEntity().getContent(), CryptoCoinEntity.class));
//            System.out.println(response.status + ". " + "User: " + message.getChat().getFirstName() + " " + message.getChat().getLastName());
            LOGGER.info(response.status + ". " + "User: " + message.getChat().getFirstName() + " " + message.getChat().getLastName());
            LOGGER.info(String.valueOf(response.data));

            String chatResponse = response.data.network + " = " + response.data.prices.get(1).price + "$";

            return new MessageCreator().createRawMessage(message, chatResponse);
        }
    }

    protected abstract HttpGet doRequest();

}
