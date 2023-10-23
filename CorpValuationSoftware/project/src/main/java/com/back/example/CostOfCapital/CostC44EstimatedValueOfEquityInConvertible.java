package com.back.example.CostOfCapital;

public class CostC44EstimatedValueOfEquityInConvertible {
    private static double EVInConvertible;

    public static double getEVInConvertible() {
        return EVInConvertible;
    }

    public static void setEVInConvertible() {
        EVInConvertible = InputForCapital.B31MarketValueOfConvertible - CostC42EstimatedValueOfStraightDebtInConvertible.getEstimatedValueOfStraightDebtInConvertible();
    }
}
