package com.panilya.tgcryptobot.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.IOException;

public abstract class AbstractPriceServiceScraping implements PriceService {

    @Override
    public SendMessage doGetCurrencyPrice(Message message) throws IOException {
        Document doc = Jsoup.connect(doRequest()).get();
        String price = doc.select("div.priceValue").text();
        System.out.println(doc.select("div.priceValue").text());
        System.out.println(message.getText()); // Returns KeyboardButton value (BTC, ETH etc.)

        return new MessageCreator().createRawMessage(message, price);
    }

    protected abstract String doRequest();

}
