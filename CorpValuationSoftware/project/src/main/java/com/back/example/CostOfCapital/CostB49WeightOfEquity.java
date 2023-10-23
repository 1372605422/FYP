package com.back.example.CostOfCapital;

public class CostB49WeightOfEquity {
    private static double weightOfEquity;

    public static double getWeightOfEquity() {
        return weightOfEquity;
    }

    /**
     * B48/E48. The weight of Equity in Cost of Capital
     */
    public static void setWeightOfEquity() {
        weightOfEquity = CostB48MarketEquity.getMarketEquity()/ CostE48MarketCapital.getMarketCapital();
    }
}
