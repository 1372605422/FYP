package com.back.example.CostOfCapital;

public class CostD48MarketPreferredStock {
    private static double marketPreferredStock;

    public static double getMarketPreferredStock() {
        return marketPreferredStock;
    }

    /**
     * B36 * B37
     * Number of Preferred Shares * Current Market Price per Share
     */
    public static void setMarketPreferredStock() {
        marketPreferredStock = InputForCapital.getB36NumberOfPreferredShares() * InputForCapital.getB37CurrentMarketPricePerShare();
    }
}
