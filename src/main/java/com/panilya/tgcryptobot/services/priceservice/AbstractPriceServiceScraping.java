package com.panilya.tgcryptobot.services.priceservice;

import com.panilya.tgcryptobot.BotConfig;
import com.panilya.tgcryptobot.services.MessageCreator;
import com.panilya.tgcryptobot.settings.ScrapingVars;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.IOException;

public abstract class AbstractPriceServiceScraping implements PriceService {

    private Document connectJsoup() throws IOException {
        return Jsoup.connect(doRequest()).get();
    }

    @Override
    public SendMessage doGetCurrencyPrice(Message message, String coinName) throws IOException {
        Document doc = connectJsoup();
        String price = doc.select("div.priceValue").text();

        if (BotConfig.SHOW_PERCENTAGE) {
            String percentage;
            try {
                if (doc.hasClass(ScrapingVars.JSOUP_PERCENTAGE_gEePkg)) {
                    percentage = doc.select(ScrapingVars.JSOUP_PERCENTAGE_gEePkg).get(0).text();
                } else {
                    percentage = doc.select(ScrapingVars.JSOUP_PERCENTAGE_feeyND).get(0).text();
                }
            } catch (IndexOutOfBoundsException ex) {
                percentage = "0%";
            }
//            System.out.println(price);
//            System.out.println(percentage);

            Elements arrow = doc.select(".gEePkg span[class^=\"icon\"]");

            final String arrowUp = "\uD83D\uDD3C";
            final String arrowDown = "\uD83D\uDD3B";

            String holdArrow;
            if (arrow.hasClass("icon-Caret-up")) {
                holdArrow = arrowUp;
            } else {
                holdArrow = arrowDown;
            }

            return new MessageCreator().createRawMessage(message, coinName + ":" + "\n" + price + " " + "*" + percentage + "*" + holdArrow);
        }

        return new MessageCreator().createRawMessage(message, coinName + ":" + "\n" + "*" + price + "*");
    }

    protected abstract String doRequest();

}
