package com.panilya.tgcryptobot.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.IOException;

public abstract class AbstractPriceServiceScraping implements PriceService {

    @Override
    public SendMessage doGetCurrencyPrice(Message message) throws IOException {
        Document doc = Jsoup.connect(doRequest()).get();

        String price = doc.select("div.priceValue").text();
        String percentage = doc.select("span[class=sc-15yy2pl-0 gEePkg]").text();
        System.out.println(price);
        System.out.println(percentage);

        Elements element = doc.select(".gEePkg span[class^=\"icon\"]");

        final String arrowUp = "\uD83D\uDD3C";
        final String arrowDown = "\uD83D\uDD3D";

        String holdArrow;
        if (element.hasClass("icon-Caret-up")) {
            holdArrow = arrowUp;
            System.out.println("UP!");
        } else {
            holdArrow = arrowDown;
            System.out.println("DOWN!");
        }

        System.out.println(message.getText()); // Returns KeyboardButton value (BTC, ETH etc.)

//        try {
//            Thread.sleep(50);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return new MessageCreator().createRawMessage(message, price + " " + percentage + holdArrow);
    }

    protected abstract String doRequest();

}
