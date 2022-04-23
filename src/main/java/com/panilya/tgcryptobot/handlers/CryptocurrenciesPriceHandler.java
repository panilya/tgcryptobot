package com.panilya.tgcryptobot.handlers;

import com.panilya.tgcryptobot.BotConfig;
import com.panilya.tgcryptobot.services.MessageCreator;
import com.panilya.tgcryptobot.services.priceservicefactories.FactoryMaker;
import com.panilya.tgcryptobot.services.priceservicefactories.PriceServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CryptocurrenciesPriceHandler extends TelegramLongPollingBot {

    Logger LOGGER = LoggerFactory.getLogger(CryptocurrenciesPriceHandler.class);

    private static final String START_COMMAND = "/start";
    private static final String CRYPTOCURRENCY_PRICE = "Show cryptocurrencies prices";
    private static final String CONVERT_PRICE = "Convert cryptocurrency to another (crypto)currency";
    private static final String SHOW_HELP = "Show help";
    private MessageCreator messageCreator = new MessageCreator();

    ExecutorService executorService = Executors.newCachedThreadPool();

    @Override
    public void onUpdateReceived(Update update) {
        executorService.execute(() -> {
            LOGGER.info("--------" + Thread.currentThread().getName() + "--------");
//            System.out.println(Thread.currentThread().getName());
            long start = System.nanoTime();
            if (update.hasMessage()) {
                try {
                    executeMessage(parseMessage(update.getMessage()));
                    LOGGER.info("Processed message in " + Duration.ofNanos(System.nanoTime() - start).toMillis() + " ms");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (update.hasCallbackQuery()) {
                try {
                    executeMessage(handleCallbackQuery(update.getCallbackQuery()));
                    LOGGER.info("Processed message in " + Duration.ofNanos(System.nanoTime() - start).toMillis() + " ms");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private SendMessage handleCallbackQuery(CallbackQuery callbackQuery) throws Exception {
        Message callbackMessage = callbackQuery.getMessage();
        String data = callbackQuery.getData();
        LOGGER.info(callbackQuery.getData());
        AnswerCallbackQuery answerCallbackQuery = new AnswerCallbackQuery(callbackQuery.getId());
        execute(answerCallbackQuery);
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
        switch (text) {
            case "BTC":
                return priceServiceFactory.createBitcoinPriceService().doGetCurrencyPrice(message, text);
            case "ETH":
                return priceServiceFactory.createEthereumPriceService().doGetCurrencyPrice(message, text);
            case "DOGE":
                return priceServiceFactory.createDogecoinPriceService().doGetCurrencyPrice(message, text);
            case "LTC":
                return priceServiceFactory.createLitecoinPriceService().doGetCurrencyPrice(message, text);
            case "SOL":
                return priceServiceFactory.createSolanaPriceService().doGetCurrencyPrice(message, text);
            case "ADA":
                return priceServiceFactory.createCardanoPriceService().doGetCurrencyPrice(message, text);
            case "BNB":
                return priceServiceFactory.createBNBPriceService().doGetCurrencyPrice(message, text);
            case "Terra":
                return priceServiceFactory.createTerraPriceService().doGetCurrencyPrice(message, text);
            case "XRP":
                return priceServiceFactory.createXRPPriceService().doGetCurrencyPrice(message, text);
            case "AVAX":
                return priceServiceFactory.createAvalanchePriceService().doGetCurrencyPrice(message, text);
            case "DOT":
                return priceServiceFactory.createPolkadotPriceService().doGetCurrencyPrice(message, text);
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