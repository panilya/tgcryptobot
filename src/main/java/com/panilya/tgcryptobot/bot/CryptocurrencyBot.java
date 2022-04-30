package com.panilya.tgcryptobot.bot;

import com.panilya.tgcryptobot.BotConfig;
import com.panilya.tgcryptobot.handlers.PriceHandler;
import com.panilya.tgcryptobot.services.MessageCreator;
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

public class CryptocurrencyBot extends TelegramLongPollingBot {

    Logger LOGGER = LoggerFactory.getLogger(CryptocurrencyBot.class);

    private static final String START_COMMAND = "/start";
    private static final String CRYPTOCURRENCY_PRICE = "Cryptocurrency prices";
    private static final String CONVERT_PRICE = "Currency Exchange";
    private static final String SHOW_HELP = "Show help";
    private final MessageCreator messageCreator = new MessageCreator();

    private final PriceHandler priceHandler = new PriceHandler();

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
                    LOGGER.error("Error while processing message", e);
                }
            } else if (update.hasCallbackQuery()) {
                try {
                    executeMessage(handleCallbackQuery(update.getCallbackQuery()));
                    LOGGER.info("Processed message in " + Duration.ofNanos(System.nanoTime() - start).toMillis() + " ms");
                } catch (Exception e) {
                    LOGGER.error("Error while processing callback", e);
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
        return priceHandler.parseCryptocurrency(callbackMessage, data);
    }

    private SendMessage parseMessage(Message message) throws Exception {
        switch (message.getText()) {
            case START_COMMAND:
                return messageCreator.createBasicMessage(message, "\uD83D\uDCC8 Choose what you want to do");
            case CRYPTOCURRENCY_PRICE:
                return messageCreator.createInlineMessage(message, "Select:");
            case CONVERT_PRICE:
                return messageCreator.createExchangeBotMessage(message);
            case SHOW_HELP:
                return messageCreator.createShowHelpMessage(message);
            default:
                return priceHandler.parseCryptocurrency(message, message.getText());
        }
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