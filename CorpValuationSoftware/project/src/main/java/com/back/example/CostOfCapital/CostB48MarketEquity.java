package com.back.example.CostOfCapital;

import com.back.StaticData.InputData;

public class CostB48MarketEquity {
    private static double marketEquity;

    public static double getMarketEquity() {
        return marketEquity;
    }

    /**
     * B6 * B7 in cost worksheet.
     * read data from inputSheet B18 and B19
     */
    public static void setMarketEquity() {
        double costB6NumberOfShares = InputData.getB18();
        double costB7PricePerShare = InputData.getB19();
        marketEquity = costB6NumberOfShares * costB7PricePerShare;
    }
}
