package com.panilya.tgcryptobot.services;

import com.google.common.collect.Lists;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class ButtonsService {

    public ReplyKeyboardMarkup createButtons() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardButtons = new KeyboardRow();
        keyboardButtons.add(new KeyboardButton("Show cryptocurrencies prices"));
        keyboardButtons.add(new KeyboardButton("Information"));
        keyboardRows.add(keyboardButtons);
        replyKeyboardMarkup.setKeyboard(keyboardRows);

        return replyKeyboardMarkup;
    }

    public InlineKeyboardMarkup createInlineCryptoKeyboard() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        EnumSet<CoinRegistry> enumSet = EnumSet.allOf(CoinRegistry.class);

        var streamOfCoins = enumSet.stream()
                .map(coin -> InlineKeyboardButton.builder()
                        .text(coin.name())
                        .callbackData(coin.getShortName())
                        .build())
                .collect(Collectors.toList());

        List<List<InlineKeyboardButton>> partitionedList = Lists.partition(streamOfCoins, 3);

        inlineKeyboardMarkup.setKeyboard(partitionedList);

        return inlineKeyboardMarkup;
    }

    public ReplyKeyboardMarkup createCryptocoinsListKeyboard() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setInputFieldPlaceholder("Enter coin name: ");

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardButtons = new KeyboardRow();

        keyboardButtons.add(new KeyboardButton("BTC"));
        keyboardButtons.add(new KeyboardButton("LTC"));
        keyboardButtons.add(new KeyboardButton("DOGE"));
        keyboardButtons.add(new KeyboardButton("ETH"));
        keyboardButtons.add(new KeyboardButton("SOL"));
        keyboardButtons.add(new KeyboardButton("ADA"));
//        keyboardButtons.add(new KeyboardButton("DOT"));
        keyboardButtons.add(new KeyboardButton("➡️"));

        keyboardRows.add(keyboardButtons);
        replyKeyboardMarkup.setKeyboard(keyboardRows);

        return replyKeyboardMarkup;
    }
}