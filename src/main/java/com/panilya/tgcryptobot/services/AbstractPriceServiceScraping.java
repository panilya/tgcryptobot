package com.panilya.tgcryptobot.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.IOException;

public abstract class AbstractPriceServiceScraping implements PriceService {

    private Document connectJsoup() throws IOException {
        Document doc = Jsoup.connect(doRequest()).get();
        return doc;
    }

    @Override
    public SendMessage doGetCurrencyPrice(Message message) throws IOException {
        Document doc = connectJsoup();
        String price = doc.select("div.priceValue").text();
//        String percentage = doc.select("span[class=sc-15yy2pl-0 gEePkg]").text();
        String percentage;
        try {
            percentage = doc.select(doGetPercentageOfCoin()).get(0).text();
        } catch (IndexOutOfBoundsException ex) {
            percentage = "0%";
        }
        System.out.println(price);
        System.out.println(percentage);

        Elements element = doc.select(".gEePkg span[class^=\"icon\"]");
//        Elements element = doc.select(" span[class^=\"icon\"]");

        final String arrowUp = "\uD83D\uDD3C";
        final String arrowDown = "\uD83D\uDD3B";

        String holdArrow;
        if (element.hasClass("icon-Caret-up")) {
            holdArrow = arrowUp;
        } else {
            holdArrow = arrowDown;
        }

        System.out.println(message.getText()); // Returns KeyboardButton value (BTC, ETH etc.)

        return new MessageCreator().createRawMessage(message, price + " " + "*" + percentage + "*" + holdArrow);
    }

    protected abstract String doRequest();

    protected abstract String doGetPercentageOfCoin();

}
