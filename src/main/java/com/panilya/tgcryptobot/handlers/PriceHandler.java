package com.panilya.tgcryptobot.handlers;

import com.panilya.tgcryptobot.BotConfig;
import com.panilya.tgcryptobot.services.MessageCreator;
import com.panilya.tgcryptobot.services.priceservice.priceservicefactories.FactoryMaker;
import com.panilya.tgcryptobot.services.priceservice.priceservicefactories.PriceServiceFactory;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class PriceHandler {

    private final PriceServiceFactory priceServiceFactory = FactoryMaker.makeFactory(BotConfig.REQUEST_TYPE);

    public SendMessage parseCryptocurrency(Message message, String text) throws Exception {
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
}