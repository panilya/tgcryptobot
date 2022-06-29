package com.panilya.tgcryptobot.handlers;

import com.panilya.tgcryptobot.bot.CryptocurrencyBot;
import com.panilya.tgcryptobot.services.MessageCreator;
import com.panilya.tgcryptobot.settings.CommandNaming;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class MessageHandler {

    private final PriceHandler priceHandler = new PriceHandler();
    private final MessageCreator messageCreator = new MessageCreator();

    public SendMessage parseMessage(Message message) throws Exception {
        switch (message.getText()) {
            case CommandNaming.START_COMMAND:
                return messageCreator.createBasicMessage(message, "\uD83D\uDCC8 Choose what you want to do");
            case CommandNaming.CRYPTOCURRENCY_PRICE:
                return messageCreator.createInlineMessage(message, "Select:");
            case CommandNaming.SHOW_HELP:
                return messageCreator.createShowHelpMessage(message);
            default:
                return priceHandler.parseCryptocurrency(message, message.getText());
        }
    }
}