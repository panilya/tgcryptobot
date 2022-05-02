package com.panilya.tgcryptobot.handlers;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class UpdateHandler {

    private final CallbackHandler callbackHandler = new CallbackHandler();

    private final MessageHandler messageHandler = new MessageHandler();

    public SendMessage handleUpdate(Update update) {
        try {
            if (update.hasCallbackQuery()) {
                return callbackHandler.handleCallback(update.getCallbackQuery());
            } else {
                return messageHandler.parseMessage(update.getMessage());
            }
        } catch (Exception e) {
            //TODO
        }
        throw new IllegalArgumentException("Error while handling update");
    }

}
