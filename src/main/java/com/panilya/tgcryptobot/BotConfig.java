package com.panilya.tgcryptobot;

public class BotConfig {
    // API Tokens
    public static final String BOT_TOKEN = System.getenv("TG_API");

    public static final Boolean SHOW_PERCENTAGE = false;

    // Bot vars
    public static final String TG_BOT_NAME = "TelegCryptoBot";

    public static final RequestType REQUEST_TYPE = RequestType.SCRAPING;

    public enum RequestType {
        API,
        SCRAPING;
    }
}
