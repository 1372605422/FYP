package com.back.example.CostOfCapital;

public class CostD49WeightOfPreferred {
    private static double weightOfPreferredStock;

    public static double getWeightOfPreferredStock() {
        return weightOfPreferredStock;
    }

    /**
     * D48/E48
     *
     */
    public static void setWeightOfPreferredStock() {
        weightOfPreferredStock = CostD48MarketPreferredStock.getMarketPreferredStock()/ CostE48MarketCapital.getMarketCapital();
    }
}
