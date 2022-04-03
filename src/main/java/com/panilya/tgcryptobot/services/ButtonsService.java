package com.panilya.tgcryptobot.services;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
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
        keyboardButtons.add(new KeyboardButton("Information"));
        keyboardRows.add(keyboardButtons);
        replyKeyboardMarkup.setKeyboard(keyboardRows);

        return replyKeyboardMarkup;
    }

    public InlineKeyboardMarkup createInlineCryptoKeyboard() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        List<InlineKeyboardButton> row1 = new ArrayList<>(3);
        row1.add(InlineKeyboardButton.builder().text("BTC").callbackData("BTC").build());
        row1.add(InlineKeyboardButton.builder().text("Ethereum").callbackData("ETH").build());
        row1.add(InlineKeyboardButton.builder().text("BNB").callbackData("BNB").build());

        List<InlineKeyboardButton> row2 = new ArrayList<>(3);
        row2.add(InlineKeyboardButton.builder().text("Solana").callbackData("SOL").build());
        row2.add(InlineKeyboardButton.builder().text("XRP").callbackData("XRP").build());
        row2.add(InlineKeyboardButton.builder().text("Terra").callbackData("Terra").build());
        
        List<InlineKeyboardButton> row3 = new ArrayList<>(3);
        row3.add(InlineKeyboardButton.builder().text("Cardano").callbackData("ADA").build());
        row3.add(InlineKeyboardButton.builder().text("Avalanche").callbackData("AVAX").build());
        row3.add(InlineKeyboardButton.builder().text("Polkadot").callbackData("DOT").build());


        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        inlineKeyboardMarkup.setKeyboard(rows);

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