package com.back.example.CostOfCapital;

public class CostC49WeightOfDebt {
    private static double weightOfDebt;

    public static double getWeightOfDebt() {
        return weightOfDebt;
    }

    /**
     * C48/E48. The weight of Debt in Cost of Capital
     *
     *
     */
    public static void setWeightOfDebt() {
        weightOfDebt = CostC48MarketDebt.getMarketDebt()/ CostE48MarketCapital.getMarketCapital();
    }
}
