package com.panilya.tgcryptobot.handlers;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;

public class CallbackHandler {

    private final PriceHandler priceHandler = new PriceHandler();

    public SendMessage handleCallback(CallbackQuery callbackQuery) throws Exception {
        Message callbackQueryMessage = callbackQuery.getMessage();
        String callbackQueryData = callbackQuery.getData();

        return priceHandler.parseCryptocurrency(callbackQueryMessage, callbackQueryData);

    }
}
