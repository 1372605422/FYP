package com.back.example.CostOfCapital;

public class CostE48MarketCapital {
    private static double MarketCapital;

    public static double getMarketCapital() {
        return MarketCapital;
    }

    /**
     * B48 + C48 + D48
     */
    public static void setMarketCapital() {
        MarketCapital = CostB48MarketEquity.getMarketEquity() + CostC48MarketDebt.getMarketDebt() + CostD48MarketPreferredStock.getMarketPreferredStock();
    }
}
