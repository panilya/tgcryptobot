package com.panilya.tgcryptobot.handlers;

import com.panilya.tgcryptobot.BotConfig;
import com.panilya.tgcryptobot.services.MessageCreator;
import com.panilya.tgcryptobot.services.priceservicefactories.FactoryMaker;
import com.panilya.tgcryptobot.services.priceservicefactories.PriceServiceFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
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
        //long start = System.nanoTime();
        if (update.hasMessage()) {
            try {
                executeMessage(parseMessage(update.getMessage()));
                //System.out.println("Processed in " + Duration.ofNanos(System.nanoTime() - start).toMillis() + " ms");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (update.hasCallbackQuery()) {
            try {
                executeMessage(handleCallbackQuery(update.getCallbackQuery()));
                //System.out.println("Processed in " + Duration.ofNanos(System.nanoTime() - start).toMillis() + " ms");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private SendMessage handleCallbackQuery(CallbackQuery callbackQuery) throws Exception {
        Message callbackMessage = callbackQuery.getMessage();
        String data = callbackQuery.getData();
        System.out.println(callbackQuery.getData());
        AnswerCallbackQuery answerCallbackQuery = new AnswerCallbackQuery(callbackQuery.getId());
        executeAsync(answerCallbackQuery);
        return parseCryptocurrency(callbackMessage, data);
    }

    private SendMessage parseMessage(Message message) throws Exception {
        switch (message.getText()) {
            case START_COMMAND:
                return messageCreator.createBasicMessage(message, "\uD83D\uDCC8 Choose what you want to do");
            case CRYPTOCURRENCY_PRICE:
                return messageCreator.createInlineMessage(message, "Select:");
            case CONVERT_PRICE:
                //TODO
            case SHOW_HELP:
                return messageCreator.createShowHelpMessage(message);
            default:
                return parseCryptocurrency(message, message.getText());
        }
    }

    //TODO: Refactor this function because in future will be many currencies
    private SendMessage parseCryptocurrency(Message message, String text) throws Exception {
        final PriceServiceFactory priceServiceFactory = FactoryMaker.makeFactory(BotConfig.REQUEST_TYPE);
        if (text.equals("BTC")) {
            return priceServiceFactory.createBitcoinPriceService().doGetCurrencyPrice(message);
        } else if (text.equals("ETH")) {
            return priceServiceFactory.createEthereumPriceService().doGetCurrencyPrice(message);
        } else if (text.equals("DOGE")) {
            return priceServiceFactory.createDogecoinPriceService().doGetCurrencyPrice(message);
        } else if (text.equals("LTC")) {
            return priceServiceFactory.createLitecoinPriceService().doGetCurrencyPrice(message);
        } else if (text.equals("SOL")) {
            return priceServiceFactory.createSolanaPriceService().doGetCurrencyPrice(message);
        } else if (text.equals("ADA")) {
            return priceServiceFactory.createCardanoPriceService().doGetCurrencyPrice(message);
        }
        return new MessageCreator().createShowHelpMessage(message);
    }

    private void executeMessage(SendMessage message) {
        try {
            executeAsync(message);
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