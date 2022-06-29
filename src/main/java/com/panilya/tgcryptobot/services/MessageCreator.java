package com.panilya.tgcryptobot.services;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;

public class MessageCreator {

    public SendMessage createCryptocoinsPriceMessage(Message message) {
        return SendMessage.builder()
                .chatId(String.valueOf(message.getChatId()))
                .text("Enter name of coin: ")
                .replyMarkup(new ButtonsService().createCryptocoinsListKeyboard())
                .build();
    }

    //TODO
    public SendMessage createShowHelpMessage(Message message) {
        return createBasicMessage(message, "To Be Done!");
    }

    public SendMessage createGreetingMessage(Message message) {
        return createBasicMessage(message, "Hello, choose what you want to do");
    }

    public SendMessage createBasicMessage(Message message, String text) {
        return SendMessage.builder()
                .chatId(String.valueOf(message.getChatId()))
                .text(text)
                .replyMarkup(new ButtonsService().createButtons())
                .build();
    }

    public SendMessage createInlineMessage(Message message, String text) {
        return SendMessage.builder()
                .chatId(message.getChatId().toString())
                .text(text)
                .replyMarkup(new ButtonsService().createInlineCryptoKeyboard())
                .build();
    }

    public SendMessage createRawMessage(Message message, String chatResponse) {
        return SendMessage.builder()
                .chatId(String.valueOf(message.getChatId()))
                .text(chatResponse)
                .parseMode("Markdown")
                .build();
    }
}
