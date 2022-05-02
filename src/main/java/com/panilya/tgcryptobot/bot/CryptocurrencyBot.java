package com.panilya.tgcryptobot.bot;

import com.panilya.tgcryptobot.BotConfig;
import com.panilya.tgcryptobot.handlers.MessageHandler;
import com.panilya.tgcryptobot.handlers.PriceHandler;
import com.panilya.tgcryptobot.handlers.UpdateHandler;
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

    private final UpdateHandler updateHandler = new UpdateHandler();

    ExecutorService executorService = Executors.newCachedThreadPool();

    @Override
    public void onUpdateReceived(Update update) {
        executorService.execute(() -> {
            LOGGER.info("--------" + Thread.currentThread().getName() + "--------");
            long start = System.nanoTime();
            if  (update.hasCallbackQuery()) {
                String callbackQueryId = update.getCallbackQuery().getId();
                AnswerCallbackQuery answerCallbackQuery = new AnswerCallbackQuery(callbackQueryId);
                executeAnswerCallbackQuery(answerCallbackQuery);
            }
            executeMessage(updateHandler.handleUpdate(update));
            LOGGER.info("Processed message in " + Duration.ofNanos(System.nanoTime() - start).toMillis() + " ms");
        });
    }

    private void executeMessage(SendMessage message) {
        try {
            execute(message);
        } catch(TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void executeAnswerCallbackQuery(AnswerCallbackQuery answerCallbackQuery) {
        try {
            execute(answerCallbackQuery);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
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