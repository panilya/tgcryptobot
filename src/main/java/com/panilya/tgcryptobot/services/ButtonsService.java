package com.panilya.tgcryptobot.services;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class ButtonsService {

    public ReplyKeyboardMarkup createButtons() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardButtons = new KeyboardRow();
        keyboardButtons.add(new KeyboardButton("Show cryptocurrencies prices"));
        keyboardButtons.add(new KeyboardButton("Show help"));
        keyboardRows.add(keyboardButtons);
        replyKeyboardMarkup.setKeyboard(keyboardRows);

        return replyKeyboardMarkup;
    }

    public ReplyKeyboardMarkup createCryptocoinsListKeyboard() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardButtons = new KeyboardRow();
        keyboardButtons.add(new KeyboardButton("BTC"));
        keyboardButtons.add(new KeyboardButton("LTC"));
        keyboardButtons.add(new KeyboardButton("DOGE"));
        keyboardButtons.add(new KeyboardButton("ETH"));

        keyboardRows.add(keyboardButtons);
        replyKeyboardMarkup.setKeyboard(keyboardRows);

        return replyKeyboardMarkup;
    }
}
