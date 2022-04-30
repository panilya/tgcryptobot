package com.panilya.tgcryptobot;

import com.panilya.tgcryptobot.bot.CryptocurrencyBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class TCrypto {

    public static void main(String[] args) {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new CryptocurrencyBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
