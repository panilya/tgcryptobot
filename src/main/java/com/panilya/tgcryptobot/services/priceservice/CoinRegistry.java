package com.panilya.tgcryptobot.services;

public enum CoinRegistry {
    BTC("BTC"),
    ETHEREUM("ETH"),
    BNB("BNB"),
    XRP("XRP"),
    SOLANA("SOL"),
    CARDANO("ADA"),
    TERRA("Terra"),
    AVALANCHE("AVAX"),
    POLKADOT("DOT");

    private final String shortName;

    CoinRegistry(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }
}
