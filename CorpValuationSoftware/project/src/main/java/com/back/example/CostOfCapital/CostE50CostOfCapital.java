package com.back.example.CostOfCapital;

public class CostE50CostOfCapital {
    private static double costOfCapital;

    public static double getCostOfCapital() {
        return costOfCapital;
    }

    /**
     * B49*B50+C49*C50+D49*D50
     */
    public static void setCostOfCapital() {
        costOfCapital = CostB49WeightOfEquity.getWeightOfEquity() * CostB50EquityComponent.getEquityComponent() + CostC49WeightOfDebt.getWeightOfDebt() * CostC50DebtComponent.getDebtComponent() + CostD49WeightOfPreferred.getWeightOfPreferredStock() * CostC50DebtComponent.getDebtComponent();
    }
}
