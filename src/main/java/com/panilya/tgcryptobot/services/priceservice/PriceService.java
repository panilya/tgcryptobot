package com.panilya.tgcryptobot.services;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.IOException;

public interface PriceService {

    SendMessage doGetCurrencyPrice(Message message, String coinName) throws IOException;

}
