package com.panilya.tgcryptobot.handlers;

import com.panilya.tgcryptobot.BotConfig;
import com.panilya.tgcryptobot.services.MessageCreator;
import com.panilya.tgcryptobot.services.priceServiceFactories.FactoryMaker;
import com.panilya.tgcryptobot.services.priceServiceFactories.PriceServiceFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class CryptocurrenciesPriceHandler extends TelegramLongPollingBot {

    private static final String START_COMMAND = "/start";
    private static final String CRYPTOCURRENCY_PRICE = "Show cryptocurrencies prices";
    private static final String CONVERT_PRICE = "Convert cryptocurrency to another (crypto)currency";
    private static final String SHOW_HELP = "Show help";

    private MessageCreator messageCreator = new MessageCreator();

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            if (message.hasText()) {
                switch (message.getText()) {
                    case START_COMMAND:
                        executeMessage(messageCreator.createBasicMessage(message, "\uD83D\uDFE5 Choose what you want to do"));
                        break;
                    case CRYPTOCURRENCY_PRICE:
                        executeMessage(messageCreator.createCryptocoinsPriceMessage(message));
                        break;
                    case CONVERT_PRICE:
                        //TODO
                        break;
                    case SHOW_HELP:
                        executeMessage(messageCreator.createShowHelpMessage(message));
                        break;
                    default:
                        try {
                            executeMessage(parseCryptocurrency(message));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                }
            }
        }
    }

    //TODO: Refactor this function because in future will be many currencies
    private SendMessage parseCryptocurrency(Message message) throws Exception {
        final PriceServiceFactory priceServiceFactory = FactoryMaker.makeFactory(BotConfig.REQUEST_TYPE);
        if (message.getText().equals("BTC")) {
            return priceServiceFactory.createBitcoinPriceService().doGetCurrencyPrice(message);
        } else if (message.getText().equals("ETH")) {
            return priceServiceFactory.createEthereumPriceService().doGetCurrencyPrice(message);
        } else if (message.getText().equals("DOGE")) {
            return priceServiceFactory.createDogecoinPriceService().doGetCurrencyPrice(message);
        } else if (message.getText().equals("LTC")) {
            return priceServiceFactory.createLitecoinPriceService().doGetCurrencyPrice(message);
        }
        return new MessageCreator().createShowHelpMessage(message);
    }

    private void executeMessage(SendMessage message) {
        try {
            execute(message);
        } catch(TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotToken() {
        return BotConfig.BOT_TOKEN;
    }

    @Override
    public String getBotUsername() {
        return BotConfig.TG_BOT_NAME;
    }
}
