package com.back.example.CostOfCapital;

public class CostC48MarketDebt {
    private static double marketDebt;

    public static double getMarketDebt() {
        return marketDebt;
    }

    /**
     *  C41+C42+C43
     */
    public static void setMarketDebt() {
        marketDebt = CostC41EstimatingMarketValueOfStraightDebt.getEstimatingMarketValueOfStraightDebt() + CostC42EstimatedValueOfStraightDebtInConvertible.getEstimatedValueOfStraightDebtInConvertible() + InputForCapital.getB33DebtValueOfOperatingLeases();
    }
}
